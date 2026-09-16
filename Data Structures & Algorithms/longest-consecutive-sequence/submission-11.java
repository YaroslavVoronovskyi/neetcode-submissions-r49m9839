class Solution {
    public int longestConsecutive(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for (int number : numbers) {
            if (!map.containsKey(number)) {
                map.put(number, map.getOrDefault(number - 1, 0) + map.getOrDefault(number + 1, 0) + 1);
                map.put(number - map.getOrDefault(number - 1, 0), map.get(number));
                map.put(number + map.getOrDefault(number + 1, 0), map.get(number));
                longest = Math.max(longest, map.get(number));
            }
        }
        return longest;
    }
}
