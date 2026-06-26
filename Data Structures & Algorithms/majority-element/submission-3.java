class Solution {
    public int majorityElement(int[] numbers) {
        int size = numbers.length;
        int[] bit = new int[32];
        for (int number : numbers) {
            for (int index = 0; index < 32; index++) {
                bit[index] += (number >> index) & 1;
            }
        }
        int result = 0;
        for (int index = 0; index < 32; index++) {
            if (bit[index] > size / 2) {
                result |= (1 << index);
            }
        }
        return result;
    }
}