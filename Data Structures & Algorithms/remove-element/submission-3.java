class Solution {
    public int removeElement(int[] numbers, int value) {
        int size = numbers.length;
        int index = 0;
        while (index < size) {
            if (numbers[index] == value) {
                numbers[index] = numbers[--size];
            } else {
                index++;
            }
        }
        return size;
    }
}