class Solution {
    public boolean containsNearbyDuplicate(int[] numbers, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < numbers.length; index++) {
            if (map.containsKey(numbers[index]) && index - map.get(numbers[index]) <= k) {
                return true;
            }
            map.put(numbers[index], index);
        }
        return false;
    }
}