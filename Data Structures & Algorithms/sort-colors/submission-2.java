class Solution {
    public void sortColors(int[] numbers) {
        int index = 0;
        int left = 0;
        int right = numbers.length - 1;
        while (index <= right) {
            if (numbers[index] == 0) {
                swap(numbers, left, index);
                left++;
            } else if (numbers[index] == 2) {
                swap(numbers, index, right);
                right--;
                index--;
            }
            index++;
        }
    }

    private void swap(int[] numbers, int index, int value) {
        int temp = numbers[index];
        numbers[index] = numbers[value];
        numbers[value] = temp;
    }
}