class Solution {
    public int reverseBits(int number) {
        int result = 0;
        for (int index = 0; index < 32; index++) {
            int bit = (number >> index) & 1;
            result += (bit << (31 - index));
        }
        return result;
    }
}
