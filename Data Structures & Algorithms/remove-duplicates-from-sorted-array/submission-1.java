class Solution {
    public int removeDuplicates(int[] numbers) {
        int size = numbers.length;
        int left = 0;
        int right = 0;
        while (right < size) {
            numbers[left]  = numbers[right];
            while (right < size && numbers[right] == numbers[left]) {
                right++;
            }
            left++;
        }
        return left;
    }
}