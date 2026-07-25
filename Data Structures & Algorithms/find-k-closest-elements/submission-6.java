class Solution {
    public List<Integer> findClosestElements(int[] array, int k, int x) {
        int left = 0;
        int right = array.length - k;
        while (right > left) {
            int middle = (left + right) / 2;
            if (x - array[middle] > array[middle + k] - x) {
                left = middle + 1;
            } else {
                right = middle;
            } 
        }
        List<Integer> result = new ArrayList<>();
        for (int index = left; index < left + k; index++) {
            result.add(array[index]);
        }
        return result;
    }
}