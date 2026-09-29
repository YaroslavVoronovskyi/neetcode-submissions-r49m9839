class Solution {
    public boolean hasDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                return true;
            }
            set.add(number);
        }
        return false;
    }
}