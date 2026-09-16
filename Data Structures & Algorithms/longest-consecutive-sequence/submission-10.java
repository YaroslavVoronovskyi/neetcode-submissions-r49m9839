class Solution {
    public int longestConsecutive(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }
        int longest = 0;

        for (int number : set) {
            if (!set.contains(number - 1)) {
                int length = 1;
                while (set.contains(number + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
