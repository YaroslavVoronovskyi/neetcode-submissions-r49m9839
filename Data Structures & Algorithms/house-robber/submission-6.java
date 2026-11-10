class Solution {
    public int rob(int[] numbers) {
        int rob1 = 0;
        int rob2 = 0;
       
        for (int number : numbers) {
            int temp = Math.max(number + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
