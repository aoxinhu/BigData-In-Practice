package com.aoxinhu.kafka.ch1_quick_start;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Date;
import java.util.Properties;
// import java.util.concurrent.Future;

/**
 * @description: 生产者客户端demo
 * 先启动客户端，再启动
 * @create: 2019-04-18 00:34
 **/
public class ProducerFastStart {
    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic.demo";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("bootstrap.servers", brokerList);

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        try {
            for (int i = 0; i < 5; i++) {

                String value = "hello, kafka! hello value-" + (new Date().getTime() + i);
                ProducerRecord<String, String> record = new ProducerRecord<>(topic, value);
   
                // ===================Strategy-1：send and forget ================
            //    producer.send(record);

                //====================Strategy-2: 同步发送================
            //    producer.send(record).get();

                //---------------利用Future的方式进行同步发送--------------
            //    Future<RecordMetadata> future = producer.send(record);
            //    RecordMetadata recordMetadata = future.get();
            //    System.out.println(recordMetadata.topic() + "-" + recordMetadata.partition() + "-" + recordMetadata.offset());

                //=====================Strategy-3: 异步发送====================
                producer.send(record, new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                        if (e != null) {
                            e.printStackTrace();
                        } else {
                            System.out.println(recordMetadata.topic() + "-"
                                    + recordMetadata.partition() + "-" + recordMetadata.offset());
                        }
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close 方法会阻塞等待之前所有的发送请求完成后再关闭 KafkaProducer
            producer.close();
        }
    }
}
