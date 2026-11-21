class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int index = 0; index < size; index++) {
            int number = numbers[index];
            int diff = target - number;
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), index};
            }
            map.put(number, index);
        }
        return new int[0];
    }
}
