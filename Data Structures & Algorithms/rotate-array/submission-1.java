class Solution {
    public void rotate(int[] numbers, int k) {
        int size = numbers.length;
        int[] temp = new int[size];
        for (int index = 0; index < size; index++) {
            temp[(index + k) % size] = numbers[index];
        }
        for (int index = 0; index < size; index++) {
            numbers[index] = temp[index];
        }
    }
}