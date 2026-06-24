class Solution {
    public int removeElement(int[] numbers, int val) {
        int k = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != val) {
                numbers[k++] = numbers[index];
            }
        }
        return k;
    }
}