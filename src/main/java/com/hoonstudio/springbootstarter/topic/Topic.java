package com.hoonstudio.springbootstarter.topic;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "topics")
public class Topic {
    @Id
    private String id;
    private String name;
    private String description;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int pricePerTopic;

    // You can do @Indexed(direction = IndexDirection.ASCENDING) for an attribute if you want it to be stored in order

    public Topic(String name, String description, int pricePerTopic) {
        this.name = name;
        this.description = description;
        this.pricePerTopic = pricePerTopic;
    }

    public Topic(){

    }

    public int getPricePerTopic() {
        return pricePerTopic;
    }

    public void setPricePerTopic(int price) {
        this.pricePerTopic = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
