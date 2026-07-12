class Twitter {

    HashMap<Integer, HashSet<Integer>> followMap;
    PriorityQueue<int[]> allTweets;
    int recency;

    public Twitter() {
        followMap = new HashMap<>();
        allTweets = new PriorityQueue<>((a, b) -> (b[2] - a[2]));
    }
    
    public void postTweet(int userId, int tweetId) {
        System.out.println(" ____ ");
        System.out.println(userId + " " + tweetId);
        allTweets.offer(new int[]{userId, tweetId, recency++});
        System.out.println(allTweets.peek()[0]);
        System.out.println(" ____ ");

    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        HashSet<Integer> followList = followMap.computeIfAbsent(userId, k -> new HashSet<>());
        followList.add(userId);
        int count = 0;
        Queue<int[]> tempQ = new LinkedList<>();

        while(!allTweets.isEmpty() && count < 10){
            int[] tweet = allTweets.poll();
            // Store temporarily
            tempQ.offer(tweet);
            if(followList.contains(tweet[0])) {
                newsFeed.add(tweet[1]);
                count++;
            }
        }

        while(!tempQ.isEmpty()) allTweets.offer(tempQ.poll());

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.get(followerId).remove(followeeId);
    }
}
