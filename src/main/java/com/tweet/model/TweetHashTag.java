package com.tweet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TweetHashTag")
public class TweetHashTag {
	
	@Id
	@Column
	String hashTagName;
	
	@JsonIgnoreProperties(value = "hashTags")
	@ManyToMany(mappedBy = "hashTags")
	private List<Tweet> tweets;

	
	public TweetHashTag() {
		super();
	}
	
	
	public TweetHashTag(String hashTagName) {
		super();
		this.hashTagName = hashTagName;
		this.tweets = new ArrayList<Tweet>();
	}


	public String getHashTagName() {
		return hashTagName;
	}

	public void setHashTagName(String hashTagName) {
		this.hashTagName = hashTagName;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	
	
	
	
	
}
