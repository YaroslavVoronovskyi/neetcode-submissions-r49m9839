class Solution {
    public boolean stoneGame(int[] piles) {
        int size = piles.length;
        int[] dp = new int[size];
        for (int l = size - 1; l >= 0; l--) {
            for (int r = l; r < size; r++) {
                boolean even = (r - l) % 2 == 0;
                int left = even ? piles[l] : 0;
                int right = even ? piles[r] : 0;
                if (l == r) {
                    dp[r] = left;
                } else {
                    dp[r] = Math.max(dp[r] + left, dp[r - 1] + right);
                }
            }
        }
        int total = 0;
        for (int pile : piles) {
            total += pile;
        }

        int aliceScore = dp[size - 1];
        return aliceScore > total - aliceScore;
    }
}