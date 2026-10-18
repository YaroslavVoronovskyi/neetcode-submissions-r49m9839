class Solution {
    public int findLucky(int[] array) {
        int result = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < array.length; index++) {
            map.put(array[index], map.getOrDefault(array[index], 0) + 1);
            result = Math.max(result, map.get(array[index]));
        }
        if (map.containsKey(result) && result == map.get(result)) {
            return result;
        } else {
            return -1;
        }
    }
}