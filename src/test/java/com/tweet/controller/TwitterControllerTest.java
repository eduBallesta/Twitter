package com.tweet.controller;

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
import com.tweet.service.ITweetService;

public class TwitterControllerTest {

	private final List<Tweet> TWEET_LIST = new ArrayList<Tweet>();
	
	private final List<Tweet> VALIDATED_TWEET_LIST = new ArrayList<Tweet>();
	
	private final Tweet NOT_VALIDATED_TWEET = new Tweet();
	
	private final Tweet VALIDATED_TWEET = new Tweet();
	
	private final Tweet NOT_FOUND_TWEET = null;
	
	@Mock
    ITweetService service;
	
	@InjectMocks
	TwitterController controller;
	
	@Before
	public void init(){
	   MockitoAnnotations.initMocks(this);
	   TWEET_LIST.add(new Tweet("1", new UserTweet(), "Test1", false));
	   TWEET_LIST.add(new Tweet("2", new UserTweet(), "Test2", false));
	   TWEET_LIST.add(new Tweet("3", new UserTweet(), "Test3", false));
	   TWEET_LIST.add(new Tweet("4", new UserTweet(), "Test4", false));
	   
	   VALIDATED_TWEET_LIST.add(new Tweet("1", new UserTweet(), "Test1", true));
	   VALIDATED_TWEET_LIST.add(new Tweet("2", new UserTweet(), "Test2", true));   
	   
	   NOT_VALIDATED_TWEET.setId("1");
	   NOT_VALIDATED_TWEET.setText("Test34");
	   NOT_VALIDATED_TWEET.setIsValidated(false);
	   
	   VALIDATED_TWEET.setId("1");
	   VALIDATED_TWEET.setText("Test34");
	   VALIDATED_TWEET.setIsValidated(true);
	     
	}
	
	@Test
	public void findAllTest() {		
		Mockito.when(service.findAllTweet()).thenReturn(TWEET_LIST);
		List<Tweet> result = controller.findAll();
		Assert.assertNotNull(result);
		Assert.assertEquals(result.size(), 4);
	    System.out.println("TwitterControllerTest --> findAllTest finished correctly");
	}
	
	@Test
	public void updateValidatedByIdTest() {
		Mockito.when(service.findById(Mockito.any())).thenReturn(NOT_VALIDATED_TWEET);
		Mockito.when(service.saveTweet(Mockito.any())).thenReturn(VALIDATED_TWEET);
		Tweet result = controller.updateValidatedById(Mockito.any());
		Assert.assertNotNull(result);
		Assert.assertEquals(result, VALIDATED_TWEET);
		System.out.println("TwitterControllerTest --> updateValidatedByIdTest finished correctly");
	}
	
	@Test
	public void updateValidatedByIdNotFoundTest() {
		Mockito.when(service.findById(Mockito.any())).thenReturn(NOT_FOUND_TWEET);
		Tweet result = controller.updateValidatedById(Mockito.any());
		Assert.assertNull(result);
		System.out.println("TwitterControllerTest --> updateValidatedByIdNotFoundTest finished correctly");
	}
	
	
	@Test
	public void findValidateTweetsTest() {
		Mockito.when(service.findValidateTweets()).thenReturn(VALIDATED_TWEET_LIST);
		List<Tweet> result = controller.findValidateTweets();
		Assert.assertNotNull(result);
		Assert.assertEquals(result.size(), 2);
	    System.out.println("TwitterControllerTest --> findValidateTweetsTest finished correctly");
	}

}