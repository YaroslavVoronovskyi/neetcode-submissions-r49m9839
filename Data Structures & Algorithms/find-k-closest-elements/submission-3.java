class Solution {
    public List<Integer> findClosestElements(int[] array, int k, int x) {
        int left = 0;
        int right = array.length - 1;
        while (right - left >= k) {
            if (Math.abs(x - array[left]) <= Math.abs(x - array[right])) {
                right--;
            } else {
                left++;
            } 
        }
        List<Integer> result = new ArrayList<>();
        for (int index = left; index <= right; index++) {
            result.add(array[index]);
        }
        return result;
    }
}