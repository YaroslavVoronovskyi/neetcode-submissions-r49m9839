class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        for (int outer = 0; outer < size; outer++) {
            for (int inner = outer + 1; inner < size; inner++) {
                if (numbers[outer] + numbers[inner] == target) {
                    return new int[]{outer, inner};
                }
            }
        }
        return new int[0];
    }
}
