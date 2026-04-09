class Solution {
    public int missingNumber(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            set.add(number);
        }
        int size = numbers.length;
        for (int index = 0; index <= size; index++) {
            if (!set.contains(index)) {
                return index;
            }
        }
        return -1;
    }
}
