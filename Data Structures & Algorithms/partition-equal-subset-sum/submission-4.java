class Solution {

    public boolean canPartition(int[] numbers) {
        int size = numbers.length;
        if (sum(numbers) % 2 != 0) {
            return false;
        }
        int target = sum(numbers) / 2;
        boolean[] array = new boolean[target + 1];
        array[0] = true;

        for (int index = 0; index < size; index++) {
            for (int item = target; item >= numbers[index]; item--) {
                array[item] = array[item] || array[item - numbers[index]];
            }
        }
        return array[target];
    }

    private int sum(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
}
