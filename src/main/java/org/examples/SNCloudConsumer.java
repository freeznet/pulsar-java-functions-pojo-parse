package org.examples;

import static org.apache.pulsar.client.api.Schema.AUTO_CONSUME;
import java.net.URL;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.schema.GenericRecord;
import org.apache.pulsar.client.impl.auth.oauth2.AuthenticationFactoryOAuth2;

public class SNCloudConsumer {
    public static void main(String[] args) throws Exception {
        String issuerUrl = "https://auth.test.cloud.gcp.streamnative.dev/";
        String credentialsUrl = "file:///Users/rui/Downloads/dev-rfu-admin.json";
        String audience = "urn:sn:pulsar:dev-rfu:dev";

        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar+ssl://cluster.dev-rfu.test.sn2.dev:6651")
                .authentication(
                        AuthenticationFactoryOAuth2
                                .clientCredentials(new URL(issuerUrl), new URL(credentialsUrl), audience))
                .build();

        String topic = "persistent://public/default/go-json-topic";

        Consumer<GenericRecord> consumer = client.newConsumer(AUTO_CONSUME()).topic(topic).subscriptionName("sub").subscribe();
        while (true) {
            // Wait for a message
            Message<GenericRecord> msg = consumer.receive();

            try {
                // Do something with the message
                System.out.println("Message received: " + new String(msg.getData()));

                // Acknowledge the message so that it can be deleted by the message broker
                consumer.acknowledge(msg);
            } catch (Exception e) {
                // Message failed to process, redeliver later
                consumer.negativeAcknowledge(msg);
            }
        }
    }
}
