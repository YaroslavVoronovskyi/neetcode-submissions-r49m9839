class Solution {
    public int removeDuplicates(int[] numbers) {
        int size = numbers.length;
        int left = 1;
        for (int right = 1; right < size; right++) {
            if (numbers[right] != numbers[right - 1]) {
                numbers[left++]  = numbers[right];
            }
        }
        return left;
    }
}