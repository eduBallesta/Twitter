package com.tweet.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tweet.model.Tweet;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TweetRepositoryTest {
	
	 @Autowired
	 TweetRepository repository;
	
	 @BeforeAll
	 public static void init() {
 
	 }
	 
	 @Test
	 public void findAll() {
		 List<Tweet> result = repository.findAll();
		 assertNotNull(result);
		 Assert.assertEquals(result.size(), 3);
		 System.out.println("TweetRepositoryTest --> findAll finished correctly");
		 
	 }
		
	 @Test
	 public void findByIdTest() {
		 Tweet result = repository.findById("23");
		 assertNotNull(result);
		 System.out.println("TweetRepositoryTest --> findAll finished correctly");
	 }
	 
	 @Test
	 public void findByIsValidatedTrueTest() {
		 List<Tweet> result = repository.findByIsValidatedTrue();
		 assertNotNull(result);
		 Assert.assertEquals(result.size(), 1);
		 System.out.println("TweetRepositoryTest --> findByIsValidatedTrueTest finished correctly");
		 
	 }
}
