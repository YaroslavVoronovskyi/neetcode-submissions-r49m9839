class Solution {
    public int removeElement(int[] numbers, int value) {
        int size = numbers.length;
        int key = 0;
        for (int index = 0; index < size; index++) {
            if (numbers[index] != value) {
                numbers[key++] = numbers[index];
            }
        }
        return key;
    }
}