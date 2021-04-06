package com.tweet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.config.DefaultProperties;
import com.tweet.model.HashTag;
import com.tweet.service.IHashTagService;

@RestController
@RequestMapping({"/hashtag"})
public class HashTagController {

	@Autowired
	DefaultProperties defaultProp;
	
	@Autowired
    IHashTagService service;
	
	
	@RequestMapping(value="/findAll", method = RequestMethod.GET)
    public List<HashTag> findAll(){
        return service.findAllHashTag();
    }
	
	@RequestMapping(value="/mostPopularHashTags", method = RequestMethod.GET)
    public List<String> mostPopularHashTags() {
		List<String> result = service.mostUsedHashTag();
		return result.stream().limit(defaultProp.getMaxhashTagNum()).collect(Collectors.toList());
    }
	

}
