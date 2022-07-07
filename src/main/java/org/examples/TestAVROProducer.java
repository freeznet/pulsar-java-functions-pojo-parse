package org.examples;

import static org.examples.SNCloudProducer.getRandom;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.net.URL;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.impl.auth.oauth2.AuthenticationFactoryOAuth2;
import org.apache.pulsar.client.impl.schema.JSONSchema;

public class TestAVROProducer {
    public static void main(String[] args) throws InterruptedException, IOException {
        String issuerUrl = "https://auth.test.cloud.gcp.streamnative.dev/";
        String credentialsUrl = "file:///Users/rui/Downloads/dev-rfu-admin.json";
        String audience = "urn:sn:pulsar:dev-rfu:cluster";

        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar+ssl://cluster-a3d4f742-b822-44d1-866e-66dd86e6b9f9.gcp-shared-gcp-use1-gazelle.streamnative.test.g.sn2.dev:6651")
                .authentication(
                        AuthenticationFactoryOAuth2
                                .clientCredentials(new URL(issuerUrl), new URL(credentialsUrl), audience))
                .build();
//        PulsarClient client = PulsarClient.builder().serviceUrl("pulsar://localhost:6650").build();
        /*
         * Producer<String> producer = client.newProducer(JSONSchema.of(String.class))
         * .topic("persistent://public/default/cilium-telemetry-4") .create();
         */
        Producer<AerospikePlayer> producer = client.newProducer(Schema.AVRO(AerospikePlayer.class)).topic("input_topic").create();
        String[] keys = {"mtv", "pvg", "nyc", "ignore"};
        for (int i=0;i<=90;i++) {
            AerospikePlayer player = new AerospikePlayer();
            player.setId(i);
            player.setName("name_"+i);
            player.setNamespace("namespace_"+i);
            player.setTtl(i*10);
            StatementBean statementBean = new StatementBean();
            statementBean.setCity("city_"+i);
            statementBean.setFoo("country_"+i);
            statementBean.setValue("v" + i);
            statementBean.setLongValue("long" + i);
            player.setStatementBean(statementBean);
            producer.newMessage(Schema.AVRO(AerospikePlayer.class)).value(player).key(getRandom(keys)).property("ROUTING", "TRUE").send();
        }
        producer.close();
        client.close();
    }
}