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

import com.tweet.model.HashTag;
import com.tweet.repository.HashTagRepository;
import com.tweet.service.impl.HashTagServiceImpl;

public class HashTagServiceTest {
	
	private final HashTag HASHTAG_RECORD = new HashTag();
	private final List<HashTag> HASHTAG_LIST = new ArrayList<HashTag>();
	private final List<String>  POPULAR_HASHTAG = new ArrayList<String>();
	
	@Mock
	HashTagRepository repository;
	
	@InjectMocks
	HashTagServiceImpl service;
	
	@Before
	public void init() {
		 MockitoAnnotations.initMocks(this);
		 HASHTAG_RECORD.setHashTag("Ayuso");
		 HASHTAG_RECORD.setId(1);
		   
		 HASHTAG_LIST.add(new HashTag("4M"));
		 HASHTAG_LIST.add(new HashTag("Ayuso"));
		 HASHTAG_LIST.add(new HashTag("Vacuna"));
		   
		 POPULAR_HASHTAG.add("MRajoy");
		 POPULAR_HASHTAG.add("SeFuerte");
		 POPULAR_HASHTAG.add("PSOE");
		 POPULAR_HASHTAG.add("Ayuso");
		 POPULAR_HASHTAG.add("Casado");	   
	}
	
	@Test
	public void saveHashTagTest() {
		Mockito.when(repository.save(Mockito.any())).thenReturn(HASHTAG_RECORD);
		HashTag result = service.saveHashTag(Mockito.any());
		Assert.assertNotNull(result);
		Assert.assertEquals(result, HASHTAG_RECORD);
	    System.out.println("HashTagServiceTest --> saveHashTagTest finished correctly");
	}
	
	@Test
	public void findAllHashTagTest() {
		Mockito.when(repository.findAll()).thenReturn(HASHTAG_LIST);
		List<HashTag> result = service.findAllHashTag();
		Assert.assertNotNull(result);
		Assert.assertEquals(result.size(), 3);
		System.out.println("HashTagServiceTest --> findAllHashTagTest finished correctly");
	}
	
	@Test
	public void mostUsedHashTagTest() {
		Mockito.when(repository.mostUsedHashTags()).thenReturn(POPULAR_HASHTAG);
		List<String> result = service.mostUsedHashTag();
		Assert.assertNotNull(result);
		Assert.assertEquals(result.size(), 5);
		System.out.println("HashTagServiceTest --> mostUsedHashTagTest finished correctly");
		
	}

}
