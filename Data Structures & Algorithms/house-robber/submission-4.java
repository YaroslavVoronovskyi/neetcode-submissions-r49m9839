class Solution {

    public int rob(int[] numbers) {
        int first = 0;
        int second  = 0;
        for (int number : numbers) {
            int temp = Math.max(number + first, second);
            first = second;
            second = temp;
        }
        return second;
    }
}
