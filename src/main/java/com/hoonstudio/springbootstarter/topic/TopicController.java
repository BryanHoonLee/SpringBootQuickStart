package com.hoonstudio.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    // {id} tells Spring that that part is a variable. so you dont have to hardcode /topics/java or etc
    // @Path Variable tells Spring that the {id} is being passed into that variable.
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    // @RequestBody tells Spring MVC that your request payload will contain a JSON representation of the topic instance.
    // and it asks it to take that request body and convert it into a topic instance and pass it to the addTopic()
    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
