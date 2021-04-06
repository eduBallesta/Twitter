package com.tweet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.model.Tweet;
import com.tweet.service.ITweetService;

@RestController
@RequestMapping({"/twitter"})
public class TwitterController {
	
	@Autowired
    ITweetService service;

    @RequestMapping(value="/findAll", method = RequestMethod.GET)
    public List<Tweet> findAll(){
        return service.findAllTweet();
    }
    
    @PostMapping("/updateValidated/{id}")
    public Tweet updateValidatedById(@RequestParam("id") String id) {
    	 Tweet result = service.findById(id);
    	 if(null != result) {
    		 result.setIsValidated(true);
    		 return service.saveTweet(result);
    	 }
    	
    	 return null;
    }
	

    @RequestMapping(value="/findValidatedTweets", method = RequestMethod.GET)
    public List<Tweet> findValidateTweets() {
    	 return service.findValidateTweets();
    }
    
}
