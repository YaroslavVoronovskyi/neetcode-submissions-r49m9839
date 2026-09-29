class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> prevMap = new HashMap<>();
        for (int index = 0; index < numbers.length; index++) {
            int number = numbers[index];
            int diff = target - number;
            if (prevMap.containsKey(diff)) {
                return new int[]{prevMap.get(diff), index};
            }
             prevMap.put(number, index);
        }
        return new int[]{};
    }
}
