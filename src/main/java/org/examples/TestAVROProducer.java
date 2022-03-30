package org.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.net.URL;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.impl.auth.oauth2.AuthenticationFactoryOAuth2;
import org.apache.pulsar.client.impl.schema.JSONSchema;

public class TestAVROProducer {
    public static void main(String[] args) throws InterruptedException, IOException {
        String issuerUrl = "https://auth.test.cloud.gcp.streamnative.dev/";
        String credentialsUrl = "file:///Users/rui/Downloads/dev-rfu-admin.json";
        String audience = "urn:sn:pulsar:dev-rfu:dev";

        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar+ssl://dev.dev-rfu.test.sn2.dev:6651")
                .authentication(
                        AuthenticationFactoryOAuth2
                                .clientCredentials(new URL(issuerUrl), new URL(credentialsUrl), audience))
                .build();
//        PulsarClient client = PulsarClient.builder().serviceUrl("pulsar://localhost:6650").build();
        /*
         * Producer<String> producer = client.newProducer(JSONSchema.of(String.class))
         * .topic("persistent://public/default/cilium-telemetry-4") .create();
         */
        //Schema.JSON
        Producer<AccuknoxJsonObject> producer = client.newProducer(JSONSchema.of(AccuknoxJsonObject.class)).topic("cloud-storage-sink-json-topic").create();
        //Producer<byte[]> producer = client.newProducer().topic("cilium-test1").create();
        FileReader fr = null;
        BufferedReader br = null;
        AccuknoxJsonObject jsonObject = null;
        for (int i=0;i<=90;i++) {
            String line = "test";
            System.out.println(line);
            //for(int i = 0 ; i< 1000000; i++)
            jsonObject = new AccuknoxJsonObject(line);
            producer.send(jsonObject);
        }
        producer.close();
        client.close();
    }
}