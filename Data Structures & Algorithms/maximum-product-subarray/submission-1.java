class Solution {
    public int maxProduct(int[] numbers) {
        int result = numbers[0];
        int currentMin = 1;
        int currentMax = 1;
        for (int number : numbers) {
            int current = currentMax * number;
            currentMax = Math.max(Math.max(number * currentMax, number * currentMin), number);
            currentMin = Math.min(Math.min(current, number * currentMin), number);
            result = Math.max(result, currentMax);
        }
        return result;
    }
}
