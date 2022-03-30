package org.examples;

import static org.apache.pulsar.client.api.Schema.AUTO_CONSUME;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.SubscriptionInitialPosition;
import org.apache.pulsar.client.api.schema.GenericObject;
import org.apache.pulsar.client.api.schema.GenericRecord;
import org.apache.pulsar.client.impl.MessageImpl;
import org.apache.pulsar.client.impl.TopicMessageImpl;
import org.apache.pulsar.client.impl.auth.AuthenticationToken;
import org.apache.pulsar.client.impl.schema.ProtobufNativeSchemaUtils;
import org.apache.pulsar.client.impl.schema.generic.GenericProtobufNativeSchema;
import org.apache.pulsar.common.schema.SchemaType;

@Slf4j
public class GenericObjectConsumer {
    public static void main(String[] args) throws Exception {
//        AuthenticationToken token = new AuthenticationToken();
//        token.configure("file:///pulsar/tokens/client/token");
        PulsarClient client = PulsarClient.builder()
                .serviceUrl("pulsar://localhost:6650")
                .authentication(
                        new AuthenticationToken("s.fFKNeid0PkUc6cY170J0cGlw"))
                .build();

        String topic = "persistent://bt_sp_prod/theos_interp_v1/spy_option-partition-0";

        Consumer<GenericRecord> consumer = client.newConsumer(AUTO_CONSUME()).topic(topic).subscriptionName("test").subscriptionInitialPosition(
                SubscriptionInitialPosition.Earliest).subscribe();

        int cnt = 0;
        while (cnt < 1) {
            // Wait for a message
            Message<GenericRecord> msg = consumer.receive();
            log.info("Received message: {}", msg);
            log.info("Received reader schema: {}", msg.getReaderSchema().orElse(null));
            log.info("Received value: {}", msg.getValue());
            log.info("Received schemaVersion: {}", msg.getValue().getSchemaVersion());
            log.info("Received schemaType: {}", msg.getValue().getSchemaType());
            log.info("Received native object: {}", msg.getValue().getNativeObject());
            log.info("Received native object string: {}", new String((byte[]) msg.getValue().getNativeObject(), StandardCharsets.UTF_8));
            log.info("Received fields: {}", msg.getValue().getFields());
            log.info("Received schema version: {}", msg.getValue().getSchemaVersion());

            Schema<GenericRecord> schema = null;
            if (msg instanceof MessageImpl) {
                MessageImpl impl = (MessageImpl) msg;
                schema = impl.getSchemaInternal();
            } else if (msg instanceof TopicMessageImpl) {
                TopicMessageImpl impl = (TopicMessageImpl) msg;
                schema = impl.getSchemaInternal();
            }

            log.info("internal schema: {}", schema);
            log.info("internal schema getNativeSchema: {}", schema.getNativeSchema());
            log.info("internal schema getSchemaInfo: {}", schema.getSchemaInfo());
            if (schema.getSchemaInfo().getType() == SchemaType.PROTOBUF_NATIVE) {
                GenericProtobufNativeSchema protobufNativeSchema =
                        (GenericProtobufNativeSchema) GenericProtobufNativeSchema.of(schema.getSchemaInfo());
                GenericRecord record = protobufNativeSchema.decode((byte[]) msg.getValue().getNativeObject());
                log.info("internal schema record: {}", record);
                log.info("internal schema schema type: {}", record.getSchemaType());
                log.info("internal schema fields: {}", record.getFields());
            }
            log.info("internal schema decode: {}", schema.decode((byte[]) msg.getValue().getNativeObject()));
            log.info("==========================");
            consumer.acknowledge(msg);
            cnt++;
        }

        consumer.close();
        client.close();
    }
}
