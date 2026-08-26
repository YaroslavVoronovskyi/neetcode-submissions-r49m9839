class Solution {

    private int[] dp;
    private int length;
    private int n;

    public boolean makesquare(int[] matchsticks) {
        int totalLength = Arrays.stream(matchsticks).sum();
        if (totalLength % 4 != 0) {
            return false;
        }
        length = totalLength / 4;
        if (Arrays.stream(matchsticks).max().getAsInt() > length) {
            return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        this.n = matchsticks.length;
        this.dp = new int[1 << n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return depthFirstSearch((1 << n) - 1,matchsticks) == 0;
    }

    private int depthFirstSearch(int mask, int[] matchsticks) {
        if (mask == 0) {
            return 0;
        }
        if (dp[mask] != Integer.MIN_VALUE) {
            return dp[mask];
        } 
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) {
                int result = depthFirstSearch(mask ^ (1 << i), matchsticks);
                if (result >= 0 && result + matchsticks[i] <= length) {
                    dp[mask] = (result + matchsticks[i]) % length;
                    return dp[mask];
                }
                if (mask == (1 << n) - 1) {
                    dp[mask] = -1;
                    return -1;
                }
            }
        }
        dp[mask] = -1;
        return dp[mask];
    }

    private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }
}