class Solution {
    public int singleNumber(int[] numbers) {
        Arrays.sort(numbers);
        int index = 0;
        while (index < numbers.length - 1) {
            if (numbers[index] == numbers[index + 1]) {
                index += 2;
            } else {
                return numbers[index];
            }
        }
        return numbers[index];
    }
}
