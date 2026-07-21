class Solution {
    public void rotate(int[] numbers, int k) {
        int size = numbers.length;
        k %= size;
        while (k > 0) {
            int temp = numbers[size - 1];
            for (int index = size - 1; index > 0; index--) {
                numbers[index] = numbers[index - 1];
            }
            numbers[0] = temp;
            k--;
        }
    }
}