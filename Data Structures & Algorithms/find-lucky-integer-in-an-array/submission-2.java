class Solution {
    public int findLucky(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < array.length; index++) {
            map.put(array[index], map.getOrDefault(array[index], 0) + 1);
        }
        int result = -1;
        for (int number : map.keySet()) {
            if (number == map.get(number)) {
                result = Math.max(result, number);
            }
        }
        return result;
    }
}