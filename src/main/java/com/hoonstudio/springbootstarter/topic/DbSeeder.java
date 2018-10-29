package com.hoonstudio.springbootstarter.topic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private TopicRepository topicRepository;

    public DbSeeder(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    // When spring boot app starts, the command line runner will be executed automatically by spring
    @Override
    public void run(String... args) throws Exception {
        Topic java = new Topic(
                "JAvaaaaa",
                "Javaav",
                25,
                new Location("USA")
        );

        Topic kotlin = new Topic(
                "kotlein",
                "koltinet",
                25,
                new Location("Korea")
        );

//        // drop all topics
//        this.topicRepository.deleteAll();
//
//        //add topics
//        List<Topic> topics = Arrays.asList(java, kotlin);
//        this.topicRepository.saveAll(topics);
    }
}
