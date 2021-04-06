package com.tweet.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.tweet.model.Tweet;
import com.tweet.model.UserTweet;
import com.tweet.repository.TweetRepository;
import com.tweet.service.impl.TweetServiceImpl;

public class TwitterServiceTest {
	
	
	private final Tweet TWEET_RECORD = new Tweet();
	
	private final List<Tweet> TWEET_LIST = new ArrayList<Tweet>();
	
	private final List<Tweet> VALIDATED_TWEET_LIST = new ArrayList<Tweet>();
	
	@Mock
	TweetRepository repository;
	
	@InjectMocks
	TweetServiceImpl service;
	
	@Before
	public void init() {
		 MockitoAnnotations.initMocks(this);
		 TWEET_LIST.add(new Tweet("1", new UserTweet(), "Test1", false));
	     TWEET_LIST.add(new Tweet("2", new UserTweet(), "Test2", false));
	     TWEET_LIST.add(new Tweet("3", new UserTweet(), "Test3", false));
	     TWEET_LIST.add(new Tweet("4", new UserTweet(), "Test4", false));
	     
	     VALIDATED_TWEET_LIST.add(new Tweet("1", new UserTweet(), "Test1", true));
		 VALIDATED_TWEET_LIST.add(new Tweet("2", new UserTweet(), "Test2", true));   
	}	 

	@Test
	public void saveTweetTest() {
		Mockito.when(repository.save(Mockito.any())).thenReturn(TWEET_RECORD);
		Tweet result = service.saveTweet(Mockito.any());
		Assert.assertNotNull(result);
		Assert.assertEquals(result, TWEET_RECORD);
		System.out.println("TwitterServiceTest --> saveTweetTest finished correctly");
		
	}
	
	@Test
	public void findByIdTest() {
		Mockito.when(repository.findById((String) Mockito.any())).thenReturn(TWEET_RECORD);
		Tweet result = service.findById(Mockito.any());
		Assert.assertNotNull(result);
		Assert.assertEquals(result, TWEET_RECORD);
		System.out.println("TwitterServiceTest --> findByIdTest finished correctly");
	}

	@Test
	public void findAllTweetTest() {
		Mockito.when(repository.findAll()).thenReturn(TWEET_LIST);
		List<Tweet> result =  repository.findAll();
		Assert.assertNotNull(result);
		Assert.assertEquals(result.size(), 4);
		System.out.println("TwitterServiceTest --> findAllTweetTest finished correctly");
	}

	@Test
	public void findValidateTweetsTest() {
		Mockito.when(repository.findByIsValidatedTrue()).thenReturn(VALIDATED_TWEET_LIST);
		List<Tweet> result =  repository.findByIsValidatedTrue();
		Assert.assertNotNull(result);
		Assert.assertEquals(result.size(), 2);
		System.out.println("TwitterServiceTest --> findValidateTweetsTest finished correctly");
	}
	
}
