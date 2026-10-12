class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] aArray = nums1;
        int[] bArray = nums2;
        int total = aArray.length + bArray.length;
        int half = (total + 1) / 2;

        if (bArray.length < aArray.length) {
            int[] temp = aArray;
            aArray = bArray;
            bArray = temp;
        }

        int left = 0;
        int right = aArray.length;
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = half - i;

            int aLeft = i > 0 ? aArray[i - 1] : Integer.MIN_VALUE;
            int aRight = i < aArray.length ? aArray[i] : Integer.MAX_VALUE;
            int bLeft = j > 0 ? bArray[j - 1] : Integer.MIN_VALUE;
            int bRight = j < bArray.length ? bArray[j] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 != 0) {
                    return Math.max(aLeft, bLeft);
                }
                return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
            } else if (aLeft > bRight) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        return -1;
    }
}
