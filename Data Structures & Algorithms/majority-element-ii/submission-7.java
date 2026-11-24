class Solution {
    public List<Integer> majorityElement(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
            if (map.containsKey(number) && map.get(number) > numbers.length / 3) {
                if (!result.contains(number)) {
                    result.add(number);
                }
            }
        }
        return result;
    }
}