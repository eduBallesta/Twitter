package com.tweet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import twitter4j.Status;

@Entity
@Table(name = "UserTweet")
public class UserTweet{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	private long id;
    
	@OneToOne
	@JoinColumn(name = "fk_Tweet", nullable = false)
	private Tweet tweet;
	
	@Column
	private String name;
	
	@Column
    private String email;
	
	@Column
    private String location;
	
	@Column
    private int followersCount;

	@Column
    private Status status;

	@Column
    private int friendsCount;
	
	@Column
    private int favouritesCount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getFriendsCount() {
		return friendsCount;
	}

	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}


	public int getFavouritesCount() {
		return favouritesCount;
	}

	public void setFavouritesCount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
	}
	
	
	@PrePersist
	private void postLoad() {
		if(null == this.email) {
			this.email = "";
		}
		
		if(null == this.location) {
			this.location = "";
		}
		
	}
	
	
	
}
