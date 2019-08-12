package topics.Design.l355DesignTwitter;
import java.util.*;
public class Twitter {
    Map<Integer, Set<Integer>> followList;
    Map<Integer, List<Tweet>> tweetList;
    int timestamp;
    /** Initialize your data structure here. */
    public Twitter() {
        followList = new HashMap<>();
        tweetList = new HashMap<>();
        timestamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!followList.containsKey(userId)) {
            followList.put(userId, new HashSet<>());
            followList.get(userId).add(userId);

        }
        if(!tweetList.containsKey(userId)) {
            tweetList.put(userId, new LinkedList<>());
        }
        tweetList.get(userId).add(new Tweet(timestamp++, tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>(10);
        if(!followList.containsKey(userId)) {
            return res;
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> (b.timestamp - a.timestamp));
        for(int id: followList.get(userId)) {
            for(Tweet t: tweetList.get(id)) {
                pq.offer(t);
            }
        }
        while(!pq.isEmpty() && res.size() < 10) {
            res.add(pq.poll().tweetId);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followList.containsKey(followerId)) {
            followList.put(followerId, new HashSet<>());
            followList.get(followerId).add(followerId);
        }
        if(!tweetList.containsKey(followerId)) {
            tweetList.put(followerId, new LinkedList<>());
        }
        if(!followList.containsKey(followeeId)) {
            followList.put(followeeId, new HashSet<>());
            followList.get(followeeId).add(followeeId);

        }
        if(!tweetList.containsKey(followeeId)) {
            tweetList.put(followeeId, new LinkedList<>());
        }
        followList.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!followList.containsKey(followerId)) {
            return;
        }
        followList.get(followerId).remove(followeeId);
    }

    class Tweet {
        int timestamp;
        int tweetId;
        public Tweet(int time, int id) {
            timestamp = time;
            tweetId = id;
        }
    }
}

