package org.examples;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.impl.schema.JSONSchema;

public class PojoProducer {
    public static void main(String[] args) throws PulsarClientException {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("http://localhost:8080")
                .build();

        Producer<StatementBean> producer = client.newProducer(JSONSchema.of(StatementBean.class))
                .topic("persistent://public/default/input")
                .create();

        StatementBean beijing = new StatementBean();
        beijing.setCity("beijing");

        StatementBean wuhan = new StatementBean();
        wuhan.setCity("wuhan");

        StatementBean xinjiang = new StatementBean();
        xinjiang.setCity("xinjiang");

        for(int i = 0; i<10; i++) {
            beijing.setValue("value" + i);
            producer.send(beijing);
            wuhan.setValue("value" + i);
            producer.send(wuhan);
            xinjiang.setValue("value" + i);
            producer.send(xinjiang);
        }
    }
}
