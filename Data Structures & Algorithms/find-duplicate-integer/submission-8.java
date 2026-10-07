class Solution {
    public int findDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int index = 0; index < numbers.length; index++) {
            if (set.contains(numbers[index])) {
                return numbers[index];
            }
            set.add(numbers[index]);
        }
        return -1;
    }
}
