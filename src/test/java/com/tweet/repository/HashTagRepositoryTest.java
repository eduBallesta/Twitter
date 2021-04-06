package com.tweet.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertNotNull;

import com.tweet.model.HashTag;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HashTagRepositoryTest {

	 @Autowired
	 HashTagRepository repository;
	
	 @BeforeAll
	 public static void init() {
 
	 }
	 
	 @Test
	 public void findAll() {
		List<HashTag> result = repository.findAll();
		assertNotNull(result);
		Assert.assertEquals(result.size(), 2);
		System.out.println("HashTagRepositoryTest --> findAll finished correctly");
	 }
	 
	 
	 @Test 
	 public void mostUsedHashTagsTest() {
		 List<String> result = repository.mostUsedHashTags();
		 assertNotNull(result);
		 Assert.assertEquals(result.size(), 2);
		 System.out.println("HashTagRepositoryTest --> mostUsedHashTagsTest finished correctly");
	 }
}
