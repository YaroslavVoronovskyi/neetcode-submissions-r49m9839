class Solution {
    public int[] countBits(int number) {
        int[] result = new int[number + 1];
        for (int num = 1; num <= number; num++) {
            for (int index = 0; index < 32; index++) {
                if((num & (1 << index)) != 0) {
                    result[num]++;
                }
            }
        }
        return result;
    }
}
