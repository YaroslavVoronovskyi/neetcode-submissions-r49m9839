class Solution {
    public int combinationSum4(int[] numbers, int target) {

        int[] array = new int[target + 1];
        array[0] = 1;
        for (int index = 1; index <= target; index++) {
            for (int number : numbers) {
                if (number <= index) {
                    array[index] += array[index - number];
                }
            }
        }
        return array[target];
    }
}