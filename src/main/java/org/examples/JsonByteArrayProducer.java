package org.examples;

import java.nio.charset.StandardCharsets;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;

public class JsonByteArrayProducer {
    public static void main(String[] args) throws Exception {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://127.0.0.1:6650")
                .build();

        String topic = "persistent://public/default/json-byte-array-topic1";
        Producer<byte[]> producer = client.newProducer(Schema.BYTES)
                .topic(topic)
                .create();

        for(int i = 0; i<10; i++) {
            producer.send("hello bytes".getBytes(StandardCharsets.UTF_8));
        }
        producer.close();
    }
}
