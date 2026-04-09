class Solution {
    public int missingNumber(int[] numbers) {
        int size = numbers.length;
        Arrays.sort(numbers);
        for (int index = 0; index < size; index++) {
            if (numbers[index] != index) {
                return index;
            }
        }
        return size;
    }
}
