class Solution {
    public boolean hasDuplicate(int[] numbers) {
        int size = numbers.length;
        Set<Integer> set = new HashSet<>();
        for (int index = 0; index < size; index++) {
            if (set.contains(numbers[index])) {
                return true;
            }
            set.add(numbers[index]);
        }
        return false;
    }
}