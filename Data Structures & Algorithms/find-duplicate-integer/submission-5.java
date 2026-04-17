class Solution {
    public int findDuplicate(int[] numbers) {
        int size = numbers.length;
        int result = 0;
        for (int b = 0; b < 32; b++) {
            int x = 0; 
            int y = 0;
            int mask = 1 << b;
            for (int number : numbers) {
                if ((number & mask) != 0) {
                    x++;
                }
            }
            for (int number = 1; number < size; number++) {
                if ((number & mask) != 0) {
                    y++;
                }
            }
            if (x > y) {
                result |= mask;
            }
        }
        return result;
    }
}
