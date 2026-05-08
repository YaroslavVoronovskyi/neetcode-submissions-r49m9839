class Solution {

    public int rob(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        return Math.max(helper(Arrays.copyOfRange(numbers, 1, numbers.length)), 
                        helper(Arrays.copyOfRange(numbers, 0, numbers.length - 1)));
    }

    private int helper(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        if (numbers.length == 1) {
            return numbers[0];
        }
        int[] array = new int[numbers.length];
        array[0] = numbers[0];
        array[1] = Math.max(numbers[0], numbers[1]);
        for (int index = 2; index < numbers.length; index++) {
            array[index] = Math.max(array[index - 1], numbers[index] + array[index - 2]);
        }

        return array[numbers.length - 1];
    }
}
