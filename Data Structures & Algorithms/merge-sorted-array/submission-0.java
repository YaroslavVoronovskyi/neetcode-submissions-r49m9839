class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int index = 0; index < n; index++) {
            nums1[index + m] = nums2[index];
        }
        Arrays.sort(nums1);
    }
}