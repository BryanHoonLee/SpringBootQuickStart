package com.hoonstudio.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;


    @GetMapping("/topics")
    public List<Topic> getAllTopics(){
        List<Topic> topics = this.topicRepository.findAll();
        return topics;
    }

    @PutMapping("/topics")
    public void insert(@RequestBody Topic topic){
        this.topicRepository.insert(topic);
    }

    // .save - if the topic does not exist, then the save method will create a new object for it
    // if it exists already, it will just update it
    @PostMapping("/topics")
    public void update(@RequestBody Topic topic){
        this.topicRepository.save(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void delete(@PathVariable("id") String id){
        this.topicRepository.deleteById(id);
    }

    @GetMapping("/topics/{id}")
    public Topic getTopicById(@PathVariable("id") String id){
       Topic topic = this.topicRepository.findTopicById(id);

        return topic;
    }

    @GetMapping("/price/{maxPrice}")
    public List<Topic> getPricePerTopicLessThan(@PathVariable("maxPrice") int maxPrice){
        List<Topic> topics = this.topicRepository.findByPricePerTopicLessThan(maxPrice);

        return topics;
    }

    @GetMapping("/topics/location/{country}")
    public List<Topic> getByCountry(@PathVariable("country") String country){
        List<Topic> topics = this.topicRepository.findByCountry(country);

        return topics;
    }



//    // {id} tells Spring that that part is a variable. so you dont have to hardcode /topics/java or etc
//    // @Path Variable tells Spring that the {id} is being passed into that variable.
//    @RequestMapping("/topics/{id}")
//    public Topic getTopic(@PathVariable String id){
//        return topicService.getTopic(id);
//    }
//
//    // @RequestBody tells Spring MVC that your request payload will contain a JSON representation of the topic instance.
//    // and it asks it to take that request body and convert it into a topic instance and pass it to the addTopic()
//    @RequestMapping(method = RequestMethod.POST, value="/topics")
//    public void addTopic(@RequestBody Topic topic){
//        topicService.addTopic(topic);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
//    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
//        topicService.updateTopic(id, topic);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
//    public void deleteTopic(@PathVariable String id){
//        topicService.deleteTopic(id);
//    }
}
