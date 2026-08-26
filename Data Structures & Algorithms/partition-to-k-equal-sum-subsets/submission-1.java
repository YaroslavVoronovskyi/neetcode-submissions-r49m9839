class Solution {

    private boolean[] used;
    private int target;
    private int n;
        
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int number : nums) {
            sum += number;
        }
        if (sum % k != 0) {
            return false;
        }

        this.target = sum / k;
        this.n = nums.length;
        Arrays.sort(nums);
        for (int index = 0; index < n / 2; index++) {
            int temp = nums[index];
            nums[index] = nums[n - index - 1];
            nums[n - index - 1] = temp;
        }
        used = new boolean[n];
        return backtrack(nums, k, 0, 0);
    }

    private boolean backtrack(int[] nums, int k, int currentSum, int start) {
        if (k == 0) {
            return true;
        }
        if (currentSum == target) {
            return backtrack(nums, k - 1, 0, 0);
        }
        for (int index = start; index < n; index++) {
            if (used[index] || currentSum + nums[index] > target) {
                continue;
            }
            used[index] = true;
            if (backtrack(nums, k, currentSum + nums[index], index + 1)) {
                return true;
            }
            used[index] = false;
        }
        return false;
    }
}