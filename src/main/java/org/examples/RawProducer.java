package org.examples;

import java.nio.charset.StandardCharsets;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.impl.schema.JSONSchema;

public class RawProducer {
    public static void main(String[] args) throws PulsarClientException {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("http://localhost:8080")
                .build();

        Producer<byte[]> producer = client.newProducer()
                .topic("persistent://public/default/input-java-topic-byte-byte")
                .create();

        for(int i = 0; i<10000000; i++) {
            producer.sendAsync("hello".getBytes(StandardCharsets.UTF_8));
        }
    }
}
