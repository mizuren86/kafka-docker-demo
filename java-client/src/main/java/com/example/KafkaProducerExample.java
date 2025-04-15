package com.example;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.Scanner;

public class KafkaProducerExample {
    public static void main(String[] args) {
        // 設定 Kafka producer 的參數
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 建立 Kafka producer
        Producer<String, String> producer = new KafkaProducer<>(props);
        Scanner scanner = new Scanner(System.in);

        System.out.println("輸入要傳送的訊息（輸入 exit 結束）：");

        // 迴圈讀取使用者輸入並送出訊息
        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine();
            if ("exit".equalsIgnoreCase(line)) {
                break;
            }

            // 傳送訊息到 topic
            producer.send(new ProducerRecord<>("test-topic", line));
            producer.flush();  // 確保馬上送出
            System.out.println("✅ 訊息已送出到 topic test-topic");
        }

        // 關閉資源
        producer.close();
        scanner.close();
        System.out.println("🛑 Kafka Producer 結束");
    }
}
