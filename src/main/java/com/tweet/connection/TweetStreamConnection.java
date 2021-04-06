package com.tweet.connection;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tweet.config.DefaultProperties;
import com.tweet.model.HashTag;
import com.tweet.model.TweetHashTag;
import com.tweet.model.Tweet;
import com.tweet.model.UserTweet;
import com.tweet.service.impl.HashTagServiceImpl;
import com.tweet.service.impl.TweetServiceImpl;

import twitter4j.FilterQuery;
import twitter4j.HashtagEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.Authorization;

@Component
public class TweetStreamConnection implements StatusListener {
	
	@Autowired
	DefaultProperties defaultProp;
	
	@Autowired
	TweetServiceImpl tweetService;
	
	@Autowired
	HashTagServiceImpl hashTagService;
	
	private TwitterStream  twitter;
	
	private TwitterStreamFactory transactionFactory;
	
	
	public TweetStreamConnection() {
		transactionFactory = new TwitterStreamFactory();
	}
	
	
	/**
	 * Method to establish the connection to twitter using twitter4j.properties credentials
	 * 
	 * 1- Authentication is checked
	 * 	In case that credentials are invalid, execution is shut down.
	 * 
	 * 2 - Listener to receive the twitter is created
	 * 
	 * 3 - Filters are set 
	 * 
	 */
	
	@PostConstruct
	public void initComponent() {
		this.twitter = transactionFactory.getInstance();
		if(!autentificate()) {
			System.out.println("Connection could not be established to TWITTER");
			System.exit(-1);
		}
		twitter.addListener(this);
		setFilters();
	}
	
	
	/**
	 * Function to set different filters to ignore Tweets
	 * In this case, next filter are sets:
	 *  
	 *  - languages: list of language filter by default: "und,es,it,fr"
	 *  - keywords:  list of keyword to search tweets. By default value is Ayuso
	 *  - follow:    publisher followers number. By default value is 1500
	 * 
	 */
	
	private void setFilters() {
		FilterQuery query = new FilterQuery();
	
		query.language(defaultProp.getLanguages());
		query.track(defaultProp.getKeywordTrack());
		query.follow(defaultProp.getFollowers());
		
		twitter.filter(query);
	}
	
	
	/**
	 * Function to check if credentials are fine
	 * @return: true:  if credentials are fine 
	 *          false: in another way
	 */

	private boolean autentificate() {
		Authorization aut = twitter.getAuthorization();
		return aut.isEnabled();
		
	}


	public TwitterStream getTwitter() {
		return twitter;
	}


	public void setTwitter(TwitterStream twitter) {
		this.twitter = twitter;
	}


	@Override
	public void onException(Exception ex) {
		System.out.println(ex);
	}


	@Override
	public void onStatus(Status status) {
		if(null != status.getUser() && status.getUser().getFollowersCount() > defaultProp.getFollowers()) {
			processTweet(status);
		}
	}


	@Override
	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		// TODO: onDeletionNotice
		// System.out.println("onDeletionNotice" + statusDeletionNotice);
	}


	@Override
	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		// TODO: onTrackLimitationNotice
		// System.out.println("onTrackLimitationNotice" + numberOfLimitedStatuses);
	}


	@Override
	public void onScrubGeo(long userId, long upToStatusId) {
		// TODO: onScrubGeo
		// System.out.println("onScrubGeo" + upToStatusId);
	}


	@Override
	public void onStallWarning(StallWarning warning) {
		// TODO: onStallWarning
		// System.out.println("onStallWarning" + warning);
	}
	
	
	/** Method to save the Twitter Persistence database 
	 * 
	 * @param status: current processed twitter
	 *  
	 */

	private void processTweet (Status status) {
		Tweet tweetRecord = new Tweet();
		tweetRecord.setId(Long.toString(status.getId()));
		
		for(HashtagEntity hashtag :status.getHashtagEntities()) {
			HashTag hashTag = new HashTag(hashtag.getText());
			hashTagService.saveHashTag(hashTag);
			
			TweetHashTag hashTagMany = new TweetHashTag(hashtag.getText());				
			tweetRecord.getHashTags().add(hashTagMany);
		}
		
		tweetRecord.setText(status.getText());
		tweetRecord.setIsValidated(false);
		
		UserTweet user = new UserTweet();
		
		user.setEmail(status.getUser().getEmail());
		user.setFavouritesCount(status.getUser().getFavouritesCount());
		user.setFollowersCount(status.getUser().getFollowersCount());
		user.setFriendsCount(status.getUser().getFriendsCount());			
		user.setLocation(status.getUser().getLocation());
		user.setName(status.getUser().getName());
		user.setStatus(status.getUser().getStatus());
		user.setTweet(tweetRecord);
		
		tweetRecord.setUser(user);			
		tweetService.saveTweet(tweetRecord);
	}
		
	
	
}
