package org.examples;

import java.io.IOException;

import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.impl.schema.ProtobufNativeSchema;
import org.apache.pulsar.client.impl.schema.ProtobufSchema;

public class TestProtobufNativeProducer {
    public static void main(String[] args) throws InterruptedException, IOException {
        PulsarClient client = PulsarClient.builder().serviceUrl("pulsar://localhost:16650").build();
//        Producer<StockProtoMessage.Stock> producer = client.newProducer(ProtobufNativeSchema.of(StockProtoMessage.Stock.class)).topic("cloud-storage-sink-json-topic").create();
//        for (int i=0;i<=90;i++) {
//            final StockProtoMessage.Stock stock = StockProtoMessage.Stock.newBuilder().
//                    setEntryId(i).setSymbol("STOCK_" + i).setSharePrice(100.0 + i * 10).build();
//            producer.send(stock);
//        }
//        producer.flush();
//        producer.close();


        Producer<byte[]> producer = client.newProducer(Schema.AUTO_PRODUCE_BYTES()).topic("cloud-storage-sink-json-topic").create();
        for (int i=0;i<=90;i++) {
            final StockProtoMessage.Stock stock = StockProtoMessage.Stock.newBuilder().
                    setEntryId(i).setSymbol("STOCK_" + i).setSharePrice(100.0 + i * 10).build();
            producer.send(stock.toByteArray());
        }
        producer.flush();
        producer.close();

//        Producer<byte[]> producer = client.newProducer(Schema.AUTO_PRODUCE_BYTES(ProtobufNativeSchema.of(StockProtoMessage.Stock.class))).topic("cloud-storage-sink-json-topic").create();
//        for (int i=0;i<=90;i++) {
//            final StockProtoMessage.Stock stock = StockProtoMessage.Stock.newBuilder().
//                    setEntryId(i).setSymbol("STOCK_" + i).setSharePrice(100.0 + i * 10).build();
//            producer.send(stock.toByteArray());
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