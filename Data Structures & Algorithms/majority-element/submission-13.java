class Solution {
    public int majorityElement(int[] numbers) {
        int size = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
            if (map.get(number) > size / 2) {
                return number;
            }
        }
        return -1;
    }
}