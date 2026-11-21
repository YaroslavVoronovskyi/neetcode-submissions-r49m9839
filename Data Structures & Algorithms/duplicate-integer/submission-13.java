class Solution {
    public boolean hasDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }
}