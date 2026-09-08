class Solution {
    public int combinationSum4(int[] numbers, int target) {
        Arrays.sort(numbers);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(target, 1);

        for (int total = target; total > 0; total--) {
            
            for (int number : numbers) {
                if (total < number) {
                    break;
                }
                map.put(total - number, map.getOrDefault(total, 0) + map.getOrDefault(total - number, 0));
            }
        }
        return map.getOrDefault(0, 0);
    }
}