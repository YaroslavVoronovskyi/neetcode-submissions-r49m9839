class Solution {
    public int findDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                return number;
            }
            set.add(number);
        }
        return -1;
    }
}
