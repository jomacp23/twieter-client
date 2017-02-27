package com.accenture.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.social.twitter.api.Twitter;

import com.accenture.social.service.TwitterTemplateCreator;


@ComponentScan(basePackages="com.accenture.social")
@SpringBootApplication
public class TwitterClientApplication {
	 @Autowired
	 private TwitterTemplateCreator twitterCreator;
	
	public static void main(String[] args) {
		SpringApplication.run(TwitterClientApplication.class, args);
	}
	
	@Bean(name="twietter")
	public Twitter createTwitter(){
		return twitterCreator.getTwitterTemplate("ldcamachoc");
	}
}
