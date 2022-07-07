package org.examples;

import java.io.IOException;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.impl.TypedMessageBuilderImpl;
import org.apache.pulsar.client.impl.schema.ProtobufNativeSchema;
import org.apache.pulsar.client.impl.schema.ProtobufSchema;
import org.apache.pulsar.common.api.proto.MessageMetadata;

public class TestProtobufNativeProducer {
    public static void main(String[] args) throws InterruptedException, IOException {
        PulsarClient client = PulsarClient.builder().serviceUrl("pulsar://localhost:6650").build();
        Producer<StockProtoMessage.Stock> producer = client.newProducer(ProtobufNativeSchema.of(StockProtoMessage.Stock.class)).topic("cloud-storage-sink-json-topic").create();
        for (int i=0;i<=5;i++) {
            final StockProtoMessage.Stock stock = StockProtoMessage.Stock.newBuilder().
                    setEntryId(i+1).setSymbol("STOCK_" + i).setSharePrice(100.0 + i * 10).putMaps("key1", "value1").putMaps("key2", "value2")
                    .setInnerStock(StockProtoMessage.InnerStock.newBuilder().setEntryId(i).setSymbol("STOCK_" + i).setSharePrice(100.0 + i * 10).build()).build();

            TypedMessageBuilderImpl typedMessageBuilder = (TypedMessageBuilderImpl) producer.newMessage();
            typedMessageBuilder.value(stock).send();
        }
        producer.flush();
        producer.close();


//        Producer<byte[]> producer = client.newProducer(Schema.BYTES).topic("cloud-storage-sink-json-topic").create();
//        for (int i=0;i<=90;i++) {
//            final StockProtoMessage.Stock stock = StockProtoMessage.Stock.newBuilder().
//                    setEntryId(i).setSymbol("STOCK_" + i).setSharePrice(100.0 + i * 10).build();
//            producer.send(stock.toByteArray());
//        }
//        producer.flush();
//        producer.close();

//        Producer<MemberClazz.Member> producer = client.newProducer(ProtobufNativeSchema.of(MemberClazz.Member.class)).topic("cloud-storage-sink-json-topic").create();
//        for (int i=0;i<=90;i++) {
//            final MemberClazz.Member member = MemberClazz.Member.newBuilder().setAddress("hee").setCity(Static.City.newBuilder().setCode("1").setName("a").build()).build();
////            final StockProtoMessage.Stock stock = StockProtoMessage.Stock.newBuilder().
////                    setEntryId(i).setSymbol("STOCK_" + i).setSharePrice(100.0 + i * 10).build();
//            producer.send(member);
//        }
//        producer.flush();
//        producer.close();

//
//        Producer<String> producer1 = client.newProducer(Schema.STRING).topic("cloud-storage-sink-json-topic1").create();
//        for (int i=0;i<=90;i++) {
//            producer1.send("STOCK_" + i);
//        }
//
//        producer1.flush();
//        producer1.close();

//        Producer<byte[]> producer = client.newProducer(Schema.AUTO_PRODUCE_BYTES(ProtobufNativeSchema.of(TheoHarbor.class))).topic("cloud-storage-sink-json-topic").create();
//        for (int i=0;i<=90;i++) {
//            final StockProtoMessage.Stock stock = StockProtoMessage.Stock.newBuilder().
//                    setEntryId(i).setSymbol("STOCK_" + i).setSharePrice(100.0 + i * 10).build();
//            producer.send(stock.toByteArray());
//        }
//        producer.flush();
//        producer.close();

        client.close();
    }
}