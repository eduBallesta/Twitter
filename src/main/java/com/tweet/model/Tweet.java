package com.tweet.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Tweet")
public class Tweet {
	
	@Id
	@Column
	private String id;
	
	@JsonIgnoreProperties(value = "tweet")
	@OneToOne(mappedBy = "tweet", cascade = CascadeType.ALL)
	private UserTweet user;
	
	@Lob
	@Column(length = 100000)
	private String text;
	
	@Column
	private Boolean isValidated;
	
	@JsonIgnoreProperties(value = "tweets")
	@Column
	@JoinTable (name = "tweet_hashtag", joinColumns = @JoinColumn (name = "fk_Tweet", nullable = false),
		     	inverseJoinColumns = @JoinColumn(name="fk_Hashtag", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<TweetHashTag> hashTags;
	
	
	
	public Tweet() {
		super();
		this.user = new UserTweet();
		this.hashTags = new ArrayList<TweetHashTag>();
	}


	public Tweet(String id, UserTweet user, String text, Boolean isValidated) {
		super();
		this.id = id;
		this.user = user;
		this.text = text;
		this.isValidated = isValidated;	
		this.user = new UserTweet();
		this.hashTags = new ArrayList<TweetHashTag>();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserTweet getUser() {
		return user;
	}

	public void setUser(UserTweet user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getIsValidated() {
		return isValidated;
	}

	public void setIsValidated(Boolean isValidated) {
		this.isValidated = isValidated;
	}


	public List<TweetHashTag> getHashTags() {
		return hashTags;
	}


	public void setHashTags(List<TweetHashTag> hashTags) {
		this.hashTags = hashTags;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hashTags == null) ? 0 : hashTags.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isValidated == null) ? 0 : isValidated.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tweet other = (Tweet) obj;
		if (hashTags == null) {
			if (other.hashTags != null)
				return false;
		} else if (!hashTags.equals(other.hashTags))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isValidated == null) {
			if (other.isValidated != null)
				return false;
		} else if (!isValidated.equals(other.isValidated))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
