package com.tweet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.model.Tweet;
import com.tweet.repository.TweetRepository;
import com.tweet.service.ITweetService;

@Service
public class TweetServiceImpl implements ITweetService {

	@Autowired
	TweetRepository repository;
	
	@Override
	public Tweet saveTweet(Tweet tweet) {
		return repository.save(tweet);
	}
	
	@Override
	public Tweet findById(String id) {
		return repository.findById(id);
	}

	@Override
	public List<Tweet> findAllTweet() {
		return repository.findAll();
	}

	@Override
	public List<Tweet> findValidateTweets() {
		return repository.findByIsValidatedTrue();
	}
	
	
	

}
