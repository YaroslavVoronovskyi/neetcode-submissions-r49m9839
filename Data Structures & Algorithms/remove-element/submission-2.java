class Solution {
    public int removeElement(int[] numbers, int val) {
        int index = 0;
        int size = numbers.length;
        while (index < size) {
            if (numbers[index] == val) {
                numbers[index] = numbers[--size];
            } else {
                index++;
            }
        }
        return size;
    }
}