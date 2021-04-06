package com.tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tweet.model.HashTag;

public interface HashTagRepository extends CrudRepository <HashTag, Integer> {
	
	
	 List<HashTag> findAll();
	 
	 @Query(value ="SELECT hashTag FROM HashTag GROUP BY hashTag ORDER BY COUNT(hashTag) desc")
	 List<String> mostUsedHashTags();
	 
}

