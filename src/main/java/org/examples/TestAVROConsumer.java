package org.examples;

import java.io.IOException;
import java.net.URL;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.SubscriptionInitialPosition;
import org.apache.pulsar.client.api.schema.Field;
import org.apache.pulsar.client.api.schema.GenericRecord;
import org.apache.pulsar.client.impl.auth.oauth2.AuthenticationFactoryOAuth2;
import org.apache.pulsar.client.impl.schema.generic.GenericAvroRecord;

public class TestAVROConsumer {
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
        Consumer<GenericRecord> consumer = client.newConsumer(Schema.AUTO_CONSUME()).topic("output_topic1").subscriptionName("sub").subscriptionInitialPosition(
                SubscriptionInitialPosition.Earliest).subscribe();
        while (true) {
            Message<GenericRecord> msg = consumer.receive();
            try {
                System.out.println("Message received: " + msg);
                GenericRecord record = msg.getValue();
                System.out.println("Message received: " + record);
                System.out.println("Message received: " + record.getNativeObject());
                if (record.getNativeObject() instanceof GenericAvroRecord) {
                    GenericAvroRecord player = (GenericAvroRecord) record.getNativeObject();
                    System.out.println("Message received: " + player.getAvroRecord());
                }
                System.out.println("Message received: " + record.getSchemaType());
                System.out.println("Message received: " + record.getFields());
                for (Field field : record.getFields()) {
                    System.out.println("Message received: " + field.getName());
                }
                consumer.acknowledge(msg);
            } catch (Exception e) {
                consumer.negativeAcknowledge(msg);
            }
        }

//        consumer.close();
//        client.close();
    }
}