class Solution {
    public int findMin(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int index = 0; index < numbers.length; index++) {
            min = Math.min(min, numbers[index]);
        }
        return min;
    }
}
