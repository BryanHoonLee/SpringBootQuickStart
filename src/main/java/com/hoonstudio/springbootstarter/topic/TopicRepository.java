package com.hoonstudio.springbootstarter.topic;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends MongoRepository<Topic, String> { // <type you want to store, string id>
    Topic findTopicById(String id);
    List<Topic> findByPricePerTopicLessThan(int maxPrice);

    // @Query when you want to create a non standard query.
    @Query(value = "{'location.country':?0}")
    List<Topic> findByCountry(String country);
}
