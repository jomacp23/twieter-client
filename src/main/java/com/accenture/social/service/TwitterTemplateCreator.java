package com.accenture.social.service;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by l.camacho.carbajal on 2/12/2017.
 */
@Service
@PropertySource("classpath:application.properties")
public class TwitterTemplateCreator {
    @Autowired
    private Environment env;

    public Twitter getTwitterTemplate(String accountName) {
        String consumerKey = env.getProperty(accountName + ".consumerKey");
        String consumerSecret = env.getProperty(accountName + ".consumerSecret");
        String accessToken = env.getProperty(accountName + ".accessToken");
        String accessTokenSecret = env.getProperty(accountName + ".accessTokenSecret");
        Preconditions.checkNotNull(consumerKey);
        Preconditions.checkNotNull(consumerSecret);
        Preconditions.checkNotNull(accessToken);
        Preconditions.checkNotNull(accessTokenSecret);

        TwitterTemplate twitterTemplate =
                new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        return twitterTemplate;
    }
}