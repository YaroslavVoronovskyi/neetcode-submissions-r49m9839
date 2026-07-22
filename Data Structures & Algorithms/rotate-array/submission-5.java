class Solution {
    public void rotate(int[] numbers, int k) {
        int size = numbers.length;
        int[] rotated = Arrays.copyOfRange(numbers, size - k % size, size);
        System.arraycopy(numbers, 0, numbers, k % size, size - k % size);
        System.arraycopy(rotated, 0, numbers, 0, rotated.length);
    }
}