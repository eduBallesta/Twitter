package com.tweet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Hashtag")
public class HashTag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	private long id;
	
	@Column
	String hashTag;
	
	
	public HashTag() {
		super();
	}

	public HashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHashTag() {
		return hashTag;
	}

	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hashTag == null) ? 0 : hashTag.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		HashTag other = (HashTag) obj;
		if (hashTag == null) {
			if (other.hashTag != null)
				return false;
		} else if (!hashTag.equals(other.hashTag))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
}
