package com.tweet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.tweet.config.DefaultProperties;


@EnableConfigurationProperties({DefaultProperties.class})
@SpringBootApplication
public class TweetApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(TweetApplication.class, args);
	}

}
