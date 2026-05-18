class Solution {

    public int findTargetSumWays(int[] numbers, int target) {
        int size = numbers.length;
        Map<Integer, Integer>[] map = new HashMap[size  + 1];
        for (int index = 0; index <= size; index++) {
            map[index] = new HashMap<>();
        }
        map[0].put(0, 1);
        for (int i = 0; i < size; i++) {
            for (Map.Entry<Integer, Integer>  entry : map[i].entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();
                map[i + 1].put(total + numbers[i], map[i + 1].getOrDefault(total + numbers[i], 0) + count);
                map[i + 1].put(total - numbers[i], map[i + 1].getOrDefault(total - numbers[i], 0) + count);
            }
        }
        return map[size].getOrDefault(target, 0);
    }
}
