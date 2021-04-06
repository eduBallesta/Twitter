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

import com.tweet.config.DefaultProperties;
import com.tweet.model.HashTag;
import com.tweet.service.IHashTagService;

public class HashTagControllerTest {

	private final List<HashTag> HASHTAG_LIST = new ArrayList<HashTag>();
	private final List<String>  POPULAR_HASHTAG = new ArrayList<String>();
	private final Long MAXHASHTAG = 10L;
	
	@Mock
	DefaultProperties defaultProp;
	
	@Mock
    IHashTagService service;
	
	@InjectMocks
	HashTagController controller;
	
	
	@Before
	public void init(){
	     MockitoAnnotations.initMocks(this);
	     HASHTAG_LIST.add(new HashTag("4M"));
	     HASHTAG_LIST.add(new HashTag("Ayuso"));
	     HASHTAG_LIST.add(new HashTag("Vacuna"));
	     
	     POPULAR_HASHTAG.add("4M");
	     POPULAR_HASHTAG.add("Vacuna");
	     POPULAR_HASHTAG.add("Ayuso");
	     POPULAR_HASHTAG.add("Casado");
	}
	
	@Test
	public void findAllTest(){
		Mockito.when(service.findAllHashTag()).thenReturn(HASHTAG_LIST);
		List<HashTag> result = controller.findAll();
		Assert.assertNotNull(result);
	    Assert.assertEquals(result.size(), 3);
	    System.out.println("HashTagControllerTest -->  findAllTest finished correctly");
	}
	
	@Test
	public void mostPopularHashTagsTest() {
		Mockito.when(service.mostUsedHashTag()).thenReturn(POPULAR_HASHTAG);
		Mockito.when(defaultProp.getMaxhashTagNum()).thenReturn(MAXHASHTAG);
		List<String> result = controller.mostPopularHashTags();
		Assert.assertNotNull(result);
	    Assert.assertEquals(result.size(), 4);
	    System.out.println("HashTagControllerTest --> mostPopularHashTagsTest finished correctly");
	}
	
	
	
}
