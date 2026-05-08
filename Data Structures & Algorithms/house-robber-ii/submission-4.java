class Solution {

    public int rob(int[] numbers) {
        return Math.max(numbers[0],
               Math.max(helper(Arrays.copyOfRange(numbers, 1, numbers.length)), 
                        helper(Arrays.copyOfRange(numbers, 0, numbers.length - 1))));
    }

    private int helper(int[] numbers) {
        int first = 0;
        int second = 0;
        for (int number : numbers) {
            int next = Math.max(first + number, second);
            first = second;
            second = next;
        }
        return second;
    }
}
