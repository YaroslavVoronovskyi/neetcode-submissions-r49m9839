class Solution {
    public int removeElement(int[] numbers, int value) {
        int index = 0;
        int size = numbers.length;
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