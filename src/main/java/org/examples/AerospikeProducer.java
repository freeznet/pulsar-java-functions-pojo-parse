package org.examples;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.impl.schema.JSONSchema;

public class AerospikeProducer {
    public static void main(String[] args) throws PulsarClientException {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("http://localhost:8080")
                .build();

        Producer<AerospikePlayer> producer = client.newProducer(JSONSchema.of(AerospikePlayer.class))
                .topic("persistent://public/default/sqs-input-28rc3")
                .create();

        AerospikePlayer p = new AerospikePlayer();

        for(int i = 0; i<10; i++) {
            p.setId(i);
            p.setName(""+i+"player");
            p.setNamespace("test");
            p.setTtl(86400);
            producer.newMessage().value(p).key(""+i).send();
        }
    }
}
