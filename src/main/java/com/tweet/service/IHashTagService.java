package com.tweet.service;

import java.util.List;

import com.tweet.model.HashTag;


public interface IHashTagService {
	
	HashTag saveHashTag(HashTag hashTag);
	
	List<HashTag> findAllHashTag();
	
	List<String> mostUsedHashTag();
	
	
}
