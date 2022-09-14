package com.aoxinhu.kafka.ch4_topic_partition;

/**
 * @description:
 * @author: arith
 * @create: 2019-04-18 22:28
 **/
public class TopicCommandUtils {

    public static void main(String[] args) {
//        createTopic();
//        describeTopic();
        listTopic();
    }

    public static void createTopic() {
        String[] options = new String[]{
                "--zookeeper", "localhost:2181",
                "--create",
                "--replication-factor", "1",
                "--partitions", "1",
                "--topic", "topic-create"
        };
        kafka.admin.TopicCommand.main(options);
    }

    public static void describeTopic() {
        String[] options = new String[]{
                "--zookeeper", "localhost:2181",
                "--describe",
                "--topic", "topic-create"
        };
        kafka.admin.TopicCommand.main(options);
    }

    public static void listTopic() {
        String[] options = new String[]{
                "--zookeeper", "localhost:2181",
                "--list"
        };
        kafka.admin.TopicCommand.main(options);
    }
}
