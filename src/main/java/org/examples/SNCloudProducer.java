package org.examples;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.impl.auth.oauth2.AuthenticationFactoryOAuth2;
import org.apache.pulsar.client.impl.schema.JSONSchema;
import org.apache.pulsar.common.schema.KeyValue;
import org.apache.pulsar.common.schema.KeyValueEncodingType;
import org.apache.pulsar.common.util.ObjectMapperFactory;

public class SNCloudProducer {

    @Data
    @AllArgsConstructor
    public static final class SimplePojo {
        private String field1;
        private String field2;
        private String foo;
    }

    public static void main(String[] args) throws Exception {
        String issuerUrl = "https://auth.test.cloud.gcp.streamnative.dev/";
        String credentialsUrl = "file:///Users/rui/Downloads/dev-rfu-rfuadmin.json";
        String audience = "urn:sn:pulsar:dev-rfu:functions";

        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar+ssl://dev.dev-rfu.test.sn2.dev:6651")
                .authentication(
                        AuthenticationFactoryOAuth2
                                .clientCredentials(new URL(issuerUrl), new URL(credentialsUrl), audience))
                .build();

//        PulsarClient client = PulsarClient.builder()
//                .serviceUrl("pulsar://127.0.0.1:6650")
//                .build();

        String topic = "persistent://public/default/field-input";

        Schema<KeyValue<SimplePojo, SimplePojo>> kvSchema = Schema.KeyValue(Schema.JSON(SimplePojo.class),
                Schema.AVRO(SimplePojo.class), KeyValueEncodingType.SEPARATED);

//        Producer<KeyValue<SimplePojo, SimplePojo>> producer = client.newProducer(kvSchema)
//                .topic(topic)
//                .create();
//
//        for (int i = 0; i < 10; i++) {
//            producer.newMessage()
//                    .value(new KeyValue<>(new SimplePojo("f1_" + i, "f2_" + i),
//                            new SimplePojo("v1_" + i, "v2_" + i)))
//                    .send();
//        }

//        Producer<String> producer = client.newProducer(Schema.STRING)
//                .topic(topic)
//                .create();
//
//        for (int i = 0; i < 10; i++) {
//            String key = "key-" + i;
//            // this is a JSON document, written to ElasticSearch
//            Map<String, String> valueMap = new HashMap<>();
//            valueMap.put("key" + i, "value" + i);
//            String value = ObjectMapperFactory.getThreadLocal().writeValueAsString(valueMap);
//            producer.newMessage()
//                    .value(value)
//                    .send();
//        }
//        producer.close();
//
//        Producer<String> producerString = client.newProducer(Schema.STRING)
//                .topic("sqs-sink-string")
//                .create();
//
//        for(int i = 0; i<10; i++) {
//            producerString.newMessage().value("hello string").key(""+i).send();
//        }
//        producerString.close();
//
//        Producer<AerospikePlayer> producerAerospikePlayer = client.newProducer(JSONSchema.of(AerospikePlayer.class))
//                .topic("sqs-sink-avro")
//                .create();
//
//        AerospikePlayer p = new AerospikePlayer();
//
//        for(int i = 0; i<10; i++) {
//            p.setId(i);
//            p.setName(""+i+"player");
//            p.setNamespace("test");
//            p.setTtl(86400);
//            producerAerospikePlayer.newMessage().value(p).send();
//        }
//        producerAerospikePlayer.close();
//
        Producer<StatementBean> producerKeys = client.newProducer(JSONSchema.of(StatementBean.class))
                .topic(topic)
                .create();

        StatementBean beijing = new StatementBean();
        beijing.setCity("beijing");
        String[] keys = {"mtv", "ignore"};
        String[] properties = {"nyc", "beijing"};
        String[] foobar = {"bar", "foo"};
        for(int i = 0; i<100; i++) {
            StatementBean m = new StatementBean();
            m.setCity(RandomStringUtils.randomAlphabetic(64));
            m.setValue(RandomStringUtils.randomAlphabetic(64));
            m.setLongValue(RandomStringUtils.randomAlphabetic(64));
            m.setFoo(getRandom(foobar));
            producerKeys.newMessage().value(m).key(getRandom(keys)).property("P1", getRandom(properties)).send();
        }
        producerKeys.close();

        client.close();
    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
