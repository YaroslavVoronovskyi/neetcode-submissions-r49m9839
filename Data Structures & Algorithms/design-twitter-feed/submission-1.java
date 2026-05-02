class Twitter {

    private int count;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, key -> new ArrayList<>()).add(new int[]{count--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        followMap.computeIfAbsent(userId, key -> new HashSet<>()).add(userId);
        for (int followeeId : followMap.get(userId)) {
            if (tweetMap.containsKey(followeeId)) {
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
            }
        }

        while (!minHeap.isEmpty() && result.size() < 10) {
            int[] current = minHeap.poll();
            result.add(current[1]);
            int index = current[3];
            if (index > 0) {
                int[] tweet = tweetMap.get(current[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], current[2], index - 1});
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, key -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId, (key, value) -> {
            value.remove(followeeId);
            return value;
        });
    }
}
