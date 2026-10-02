class Solution {
    public int removeElement(int[] numbers, int value) {
        int key = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != value) {
                numbers[key++] = numbers[index];
            }
        }
        return key;
    }
}