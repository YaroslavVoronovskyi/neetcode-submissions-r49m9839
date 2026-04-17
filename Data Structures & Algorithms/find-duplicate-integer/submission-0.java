class Solution {
    public int findDuplicate(int[] numbers) {
        Arrays.sort(numbers);
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == numbers[index + 1]) {
                return numbers[index];
            }
        }
        return -1;
    }
}
