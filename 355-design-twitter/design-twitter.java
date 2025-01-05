import java.util.*;

class Twitter {

    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> followers; // follower -> followees
    private Map<Integer, List<Tweet>> tweets; // userId -> tweets

    private class Tweet {
        int id;
        int time;
        
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        Set<Integer> followees = followers.getOrDefault(userId, new HashSet<>());
        followees.add(userId); // Include the user's own tweets

        for (int followeeId : followees) {
            List<Tweet> tweetList = tweets.getOrDefault(followeeId, new ArrayList<>());
            for (Tweet tweet : tweetList) {
                pq.offer(tweet);
                if (pq.size() > 10) {
                    pq.poll(); // Keep only the most recent 10 tweets
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().id); // Add tweets in reverse order
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
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