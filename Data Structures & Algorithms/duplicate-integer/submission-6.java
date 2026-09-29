class Solution {
    public boolean hasDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int index = 0; index < numbers.length; index++) {
            if (set.contains(numbers[index])) {
                return true;
            }
            set.add(numbers[index]);
        }
        return false;
    }
}