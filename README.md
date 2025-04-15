# Kafka Docker Demo

這是一個在 WSL Ubuntu 環境下，透過 Docker Compose 啟動 Kafka + Zookeeper，並用 Java 執行測試的專案。

環境
WSL 2.4.13.0
Ubuntu 24.04.2
Docker Desktop + Docker Compose
Maven 3.8.7
Java version 21.0.6

## 啟動方式

````bash
docker compose up -d


## Java Kafka Client 範例

在 `java-client/` 資料夾中包含：

- KafkaProducerExample.java
- KafkaConsumerExample.java
- pom.xml（含 Kafka Client 與 Maven plugin）

### 執行方式

```bash
cd java-client
mvn compile
mvn exec:java -Dexec.mainClass="com.example.KafkaProducerExample"
mvn exec:java -Dexec.mainClass="com.example.KafkaConsumerExample"

````
