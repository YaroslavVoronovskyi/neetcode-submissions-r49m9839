class Solution {
    public boolean hasDuplicate(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if(numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}