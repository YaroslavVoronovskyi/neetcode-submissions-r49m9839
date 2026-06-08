class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] array1 = nums1;
        int[] array2 = nums2;
        int total = array1.length + array2.length;
        int half = (total + 1) / 2;
        if (array2.length < array1.length) {
            int[] temp = array1;
            array1 = array2;
            array2 = temp;
        }
        int left = 0;
        int right = array1.length;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = half - i;
            int left1 = i > 0 ? array1[i - 1] : Integer.MIN_VALUE;
            int right1 = i < array1.length ? array1[i] : Integer.MAX_VALUE;
            int left2 = j > 0 ? array2[j - 1] : Integer.MIN_VALUE;
            int right2 = j < array2.length ? array2[j] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 != 0) {
                    return Math.max(left1, left2);
                }
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return -1;
    }
}
