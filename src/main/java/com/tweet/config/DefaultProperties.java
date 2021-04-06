package com.tweet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


/* Configuration class to load the default properties used in the filters */

@ConfigurationProperties(prefix = "default")
public class DefaultProperties {
	
	private String[] languages;
	
	private Long followers;
	
	private Long maxhashTagNum;
	
	private String[] keywordTrack;
	

	public String[] getLanguages() {
		return languages;
	}

	public Long getFollowers() {
		return followers;
	}

	public void setFollowers(Long followers) {
		this.followers = followers;
	}

	public Long getMaxhashTagNum() {
		return maxhashTagNum;
	}

	public void setMaxhashTagNum(Long maxhashTagNum) {
		this.maxhashTagNum = maxhashTagNum;
	}

	public String[] getKeywordTrack() {
		return keywordTrack;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public void setKeywordTrack(String[] keywordTrack) {
		this.keywordTrack = keywordTrack;
	}
	
	  
}


