class Solution {
    public void rotate(int[] numbers, int k) {
        int size = numbers.length;
        k %= size;
        int count = 0;
        reverse(numbers, 0, size - 1);
        reverse(numbers, 0, k - 1);
        reverse(numbers, k, size - 1);
    }

    private void reverse(int[] numbers, int left, int right) {
        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
    }
}