class Solution {
    public int firstMissingPositive(int[] numbers) {
        int size = numbers.length;
        boolean[] seen = new boolean[size];
        for (int number : numbers) {
            if (number > 0 && number <= size) {
                seen[number - 1] = true;
            }
        }
        for (int index = 0; index < size; index++) {
            if (!seen[index]) {
                return index + 1;
            }
        }
        return size + 1;
    }
}