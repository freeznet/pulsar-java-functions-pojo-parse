package org.examples;

import net.jodah.typetools.TypeResolver;
import org.apache.pulsar.client.api.BatcherBuilder;
import org.apache.pulsar.client.impl.BatchMessageContainerBase;
import org.apache.pulsar.io.core.Sink;
import org.apache.pulsar.io.core.Source;
import org.apache.pulsar.io.kafka.connect.KafkaConnectSource;

public class TypePrinter {
    public static void main(String[] args) throws Exception {
//        Class<?> typeArg = TypeResolver.resolveRawArgument(Source.class, KafkaConnectSource.class);
//        System.out.println(typeArg.getName());

        BatcherBuilder containerBuilder = BatcherBuilder.DEFAULT;
        BatchMessageContainerBase batchMessageContainer = (BatchMessageContainerBase)containerBuilder.build();
    }
}
