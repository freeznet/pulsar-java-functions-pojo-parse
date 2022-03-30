package org.examples;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.schema.GenericRecord;

public class JsonByteArrayConsumer {
    public static void main(String[] args) throws Exception {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://127.0.0.1:6650")
                .build();

        String topic = "persistent://public/default/json-byte-array-topic";

        Consumer<GenericRecord> consumer = client.newConsumer(Schema.AUTO_CONSUME()).topic(topic).subscriptionName("sub").subscribe();
        while (true) {
            Message<GenericRecord> msg = consumer.receive();
            try {
                System.out.println("Message received: " + msg.toString());
                consumer.acknowledge(msg);
            } catch (Exception e) {
                consumer.negativeAcknowledge(msg);
            }
        }

    }
}
