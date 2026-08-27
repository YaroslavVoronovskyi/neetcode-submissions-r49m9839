class Solution {
        
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int number : nums) {
            total += number;
        }
        if (total % k != 0) {
            return false;
        }

        int target = total / k;
        int size = nums.length;
        int n = 1 << size;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int mask = 0; mask < n; mask++) {
            if (dp[mask] == -1) {
                continue;
            }
            for (int i = 0; i < size; i++) {
                if ((mask & (1 << i)) == 0 && dp[mask] + nums[i] <= target) {
                    dp[mask | (1 << i)] = (dp[mask] + nums[i]) % target;
                }
            }
        }
        return dp[n - 1] == 0;
    }
}