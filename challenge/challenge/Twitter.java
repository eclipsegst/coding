package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zhaolong Zhong Jul 1, 2016
 * 
 * Design Twitter
 * 
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. 
 * Your design should support the following methods:
 * 
 * postTweet(userId, tweetId): Compose a new tweet.
 * 
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * 
 * follow(followerId, followeeId): Follower follows a followee.
 * 
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * 
 * Example:
 * Twitter twitter = new Twitter();
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class Twitter {
	List<Integer> tweets;
	HashMap<Integer, List<Integer>> followers;
	HashMap<Integer, List<Integer>> userTweetMap;
	
	/** Initialize your data structure here. */
    public Twitter() {
        this.tweets = new ArrayList<Integer>();
        this.followers = new HashMap<Integer, List<Integer>>();
        this.userTweetMap = new HashMap<Integer, List<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Integer> list = new ArrayList<Integer>();
        if (userTweetMap.containsKey(userId)) {
        	list = userTweetMap.get(userId);
        }
        
        list.add(tweetId);
        userTweetMap.put(userId, list);
        this.tweets.add(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	List<Integer> result = new ArrayList<Integer>();
    	List<Integer> allList = new ArrayList<Integer>();
        
    	// user own feeds
    	if (userTweetMap.containsKey(userId)) {
    		allList.addAll(userTweetMap.get(userId));
    	}
    	
    	// followees feeds
    	List<Integer> followees = new ArrayList<Integer>();
        
        if (followers.containsKey(userId)) {
        	followees = followers.get(userId);
        }
        
        for (int i = 0; i < followees.size(); i++) {
        	if (userTweetMap.containsKey(followees.get(i))) {
        		allList.addAll(userTweetMap.get(followees.get(i)));
        	}
        }
    
        Set<Integer> set = new HashSet<Integer> (allList);
        int k = 0;
        for (int i = tweets.size() - 1; i >= 0; i--) {
        	if (k == 10) {
        		break;
        	}
        	
        	int tweetId = tweets.get(i);
        	if (set.contains(tweetId)) {
        		result.add(tweetId);
        		k++;
        	}
        }
        
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if (followerId == followeeId) {
    		return;
    	}
    	
        if (!followers.containsKey(followerId)) {
        	followers.put(followerId, new ArrayList<Integer>());
        }
        
        if (followers.get(followerId).contains(followeeId)) {
        	return;
        }
        
        followers.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if (followerId < 0 || followeeId < 0 || followerId == followeeId) {
    		return;
    	}
    	
        if (!followers.containsKey(followerId)) {
        	return;
        }
        
        List<Integer> followees = followers.get(followerId);
        if (followees.contains(followeeId)) {
        	followees.remove(Integer.valueOf(followeeId));
        	followers.put(followerId, followees);
        }
    }
    
    public static void main(String[] args) {
    	Twitter twitter = new Twitter();
    	twitter.postTweet(1, 5);
    	twitter.getNewsFeed(1);
    	twitter.follow(1, 2);
    	twitter.postTweet(2, 6);
    	twitter.getNewsFeed(1);
    	twitter.unfollow(1, 2);
    	
    	List<Integer> news = twitter.getNewsFeed(1);
    	
    	System.out.println(Arrays.toString(news.toArray()));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */