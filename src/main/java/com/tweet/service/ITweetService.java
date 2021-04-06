package com.tweet.service;

import java.util.List;

import com.tweet.model.Tweet;


public interface ITweetService {
	
	Tweet saveTweet(Tweet tweet);
	
	Tweet findById(String id);
	
	List<Tweet> findAllTweet();
	
	List<Tweet> findValidateTweets();
	
	
}
