package com.tweet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweet.model.HashTag;
import com.tweet.repository.HashTagRepository;
import com.tweet.service.IHashTagService;

@Service
public class HashTagServiceImpl implements IHashTagService {
	
	@Autowired
	HashTagRepository repository;


	@Override
	public HashTag saveHashTag(HashTag hashTag) {
		return repository.save(hashTag);
	}
	
	@Override
	public List<HashTag> findAllHashTag() {
		return repository.findAll();
	}

	@Override
	public List<String> mostUsedHashTag() {
		return repository.mostUsedHashTags();
	}

	

	

}
