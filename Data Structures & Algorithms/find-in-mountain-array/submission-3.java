/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArray) {
        int size = mountainArray.length();
        int l = 1;
        int r = size - 2;
        int peak = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            int left = mountainArray.get(m - 1);
            int middle = mountainArray.get(m);
            int right = mountainArray.get(m + 1);
            if (left < middle && middle < right) {
                l = m + 1;
            } else if (left > middle && middle > right) {
                r = m - 1;
            } else {
                peak = m;
                break;
            }
        }
        l = 0;
        r = peak - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int value = mountainArray.get(m);
            if (value < target) {
                l = m + 1;
            } else if (value > target) {
                r = m - 1;
            } else {
                return m;
            }
        }

        l = peak;
        r = size - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int value = mountainArray.get(m);
            if (value > target) {
                l = m + 1;
            } else if (value < target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}