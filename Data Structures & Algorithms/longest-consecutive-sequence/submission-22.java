class Solution {
    public int longestConsecutive(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        Arrays.sort(numbers);
        int count = 0;
        int current = numbers[0];
        int streak = 0;
        int index = 0;
        while (index < numbers.length) {
            if (current != numbers[index]) {
                current = numbers[index];
                streak = 0;
            }
            while (index < numbers.length && numbers[index] == current) {
                index++;
            }
            streak++;
            current++;
            count = Math.max(count, streak);
        }
        return count;
    }
}
