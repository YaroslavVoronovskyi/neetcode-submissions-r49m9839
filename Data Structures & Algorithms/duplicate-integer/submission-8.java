class Solution {
    public boolean hasDuplicate(int[] numbers) {
        int size = numbers.length;
        for (int outer = 0; outer < size; outer++) {
            for (int inner = outer + 1; inner < size; inner++) {
                if (numbers[outer] == numbers[inner]) {
                    return true;
                }
            }
        }
        return false;
    }
}