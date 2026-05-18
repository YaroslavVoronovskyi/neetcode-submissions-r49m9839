class Solution {

    public int findTargetSumWays(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int number : numbers) {
            Map<Integer, Integer> next = new HashMap<>();
            for (Map.Entry<Integer, Integer>  entry : map.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                next.put(total + number, next.getOrDefault(total + number, 0) + count);
                next.put(total - number, next.getOrDefault(total - number, 0) + count);
            }
            map = next;
        }
        return map.getOrDefault(target, 0);
    }
}
