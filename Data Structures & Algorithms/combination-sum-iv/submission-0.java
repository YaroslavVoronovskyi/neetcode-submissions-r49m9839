class Solution {
    public int combinationSum4(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int total = 1; total <= target; total++) {
            map.put(total, 0);
            for (int number : numbers) {
                map.put(total, map.get(total) + map.getOrDefault(total - number, 0));
            }
        }
        return map.get(target);
    }
}