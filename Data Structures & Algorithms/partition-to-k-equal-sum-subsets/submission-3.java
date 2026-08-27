class Solution {

    private int target;
    private int n;
        
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int number : nums) {
            total += number;
        }
        if (total % k != 0) {
            return false;
        }

        this.target = total / k;
        this.n = nums.length;
        Arrays.sort(nums);
        reverse(nums);
        return backtrack(nums, 0, k, 0, (1 << this.n) - 1);
    }

    private boolean backtrack(int[] nums, int i, int k, int subsetSum, int mask) {
        if (k == 0) {
            return true;
        }
        if (subsetSum == target) {
            return backtrack(nums, 0, k - 1, 0, mask);
        }
        for (int j = i; j < n; j++) {
            if ((mask & (1 << j)) == 0 || subsetSum + nums[j] > target) {
                continue;
            }
            if (backtrack(nums, j +1, k, subsetSum + nums[j], mask ^ (1 << j))) {
                return true;
            }
            if (subsetSum == 0) {
                return false;
            }
        }
        return false;
    }

    private void reverse(int[] nums) {
        int left = 0;
        int right = this.n - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        } 
    }
}