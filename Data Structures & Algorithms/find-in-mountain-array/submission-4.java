/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    private Map<Integer, Integer> cache = new HashMap<>();

    private int get(int index, MountainArray mountainArray) {
        if (!cache.containsKey(index)) {
            cache.put(index, mountainArray.get(index));
        }
        return cache.get(index);
    }

    private int binarySearch(int l, int r, boolean ascending, MountainArray mountainArray, int target) {
        while (l <= r) {
            int m = (l + r) >> 1;
            int value = get(m, mountainArray);
            if (value == target) {
                return m;
            }
            if (ascending == (value < target)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArray) {
        int size = mountainArray.length();
        int l = 1;
        int r = size - 2;
        int peak = 0;
        while (l <= r) {
            int m = (l + r) >> 1;
            int left = get(m - 1, mountainArray);
            int middle = get(m, mountainArray);
            int right = get(m + 1, mountainArray);
            if (left < middle && middle < right) {
                l = m + 1;
            } else if (left > middle && middle > right) {
                r = m - 1;
            } else {
                peak = m;
                break;
            }
        }
        int result = binarySearch(0, peak, true, mountainArray, target);
        if (result != -1) {
            return result;
        }
        return binarySearch(peak, size - 1, false, mountainArray, target);
    }
}