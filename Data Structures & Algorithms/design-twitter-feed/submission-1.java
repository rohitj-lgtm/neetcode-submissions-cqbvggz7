class Twitter {
    private Map<Integer, Set<Integer>> followers;
    private Map<Integer, List<int[]>> tweets;
    private int count;

    public Twitter() {
        this.followers = new HashMap<>();
        this.tweets = new HashMap<>();
        this.count = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        count++;
        if(!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(new int[]{count, tweetId});
        // if(tweets.get(userId).size() > 10) {
        //     tweets.get(userId).remove(0);
        // } 
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> followees = followers.getOrDefault(userId, new HashSet<>());
        Set<Integer> feedUsers = new HashSet<>(followees);
        feedUsers.add(userId);
        for (int followee : feedUsers) {
            if (tweets.containsKey(followee)) {
                List<int[]> userTweets = tweets.get(followee);
                int index = userTweets.size() - 1;
                int[] tweet = userTweets.get(index);
                maxHeap.offer(new int[]{tweet[0], tweet[1], followee, index});
            }
        }
        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] tweet = maxHeap.poll();
            res.add(tweet[1]);
            if (tweet[3] > 0) {
                List<int[]> userTweets = tweets.get(tweet[2]);
                int index = tweet[3] - 1;
                int[] nextTweet = userTweets.get(index);
                maxHeap.offer(new int[]{nextTweet[0], nextTweet[1], tweet[2], index});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}
