class Solution {
    public List<Integer> findClosestElements(int[] array, int k, int x) {
        int left = 0;
        int right = array.length - 1;
        while (right > left) {
            int middle = (left + right) / 2;
            if (array[middle] < x) {
                left = middle + 1;
            } else {
                right = middle;
            } 
        }
        left = left - 1;
        right = left + 1;
        while (right - left - 1 < k) {
            if (left < 0) {
                right++;
            } else if (right >= array.length) {
                left--;
            } else if (Math.abs(array[left] - x) <= Math.abs(array[right] - x)) {
                left--;
            } else {
                right++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int index = left + 1; index < right; index++) {
            result.add(array[index]);
        }
        return result;
    }
}