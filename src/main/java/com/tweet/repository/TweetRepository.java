package com.tweet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tweet.model.Tweet;

public interface TweetRepository extends CrudRepository <Tweet, Integer> {
	
	 List<Tweet> findAll();
	
	 Tweet findById(String id);
	 
	 List<Tweet> findByIsValidatedTrue();

	 
}
