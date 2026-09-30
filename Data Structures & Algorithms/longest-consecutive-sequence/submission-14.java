class Solution {
    public int longestConsecutive(int[] numbers) {
        Set<Integer> store = new HashSet<>();
        for (int number : numbers) {
            store.add(number);
        }
        int longest = 0;
        for (int number : numbers) {
            if (!store.contains(number - 1)) {
                int length = 1;
                while (store.contains(number + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
