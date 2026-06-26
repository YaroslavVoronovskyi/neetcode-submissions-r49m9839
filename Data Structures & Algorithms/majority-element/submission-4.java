class Solution {
    public int majorityElement(int[] numbers) {
        int result = 0;
        int count = 0;
        for (int number : numbers) {
            if (count == 0) {
                result = number;
            }
            count += (number == result) ? 1 : -1;
        }
        return result;
    }
}