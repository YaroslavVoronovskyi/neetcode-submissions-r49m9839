class Solution {
    public List<Integer> findClosestElements(int[] array, int k, int x) {
        int size = array.length;
        int idx = 0;        
        for (int index = 1; index < size; index++) {
            if (Math.abs(x - array[idx]) > Math.abs(x - array[index])) {
                idx = index;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(array[idx]);
        int left = idx - 1;
        int right = idx + 1;
        while (result.size() < k) {
            if (left >= 0 && right < size) {
                if (Math.abs(x - array[left]) <= Math.abs(x - array[right])) {
                    result.add(array[left--]);
                } else {
                    result.add(array[right++]);
                }
            } else if (left >= 0) {
                result.add(array[left--]);
            } else if (right < size) {
                result.add(array[right++]);
            }
        }
        Collections.sort(result);
        return result;
    }
}