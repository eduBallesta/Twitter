package com.tweet.connection;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tweet.config.DefaultProperties;
import com.tweet.service.impl.HashTagServiceImpl;
import com.tweet.service.impl.TweetServiceImpl;

public class TweetStreamConnectionTest {

	@Mock
	DefaultProperties defaultProp;
	
	@Mock
	TweetServiceImpl tweetService;
	
	@Mock
	HashTagServiceImpl hashTagService;
	
	@InjectMocks 
	TweetStreamConnection connectionStream;
	
	@Before
	public void init(){
	   MockitoAnnotations.initMocks(this);
	   
	}
	
	@Test
	public void initComponent() {
		
	}
	
	
	
	
	
}
