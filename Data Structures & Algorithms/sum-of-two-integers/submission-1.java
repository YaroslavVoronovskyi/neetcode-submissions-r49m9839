class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int result = 0;
        int mask = 0xFFFFFFFF;
        for (int index = 0; index < 32; index++) {
            int aBit = (a >> index) & 1;
            int bBit = (b >> index) & 1;
            int currentBit = aBit ^ bBit ^ carry;
            carry = (aBit + bBit + carry) >= 2 ? 1 : 0;
            if (currentBit != 0) {
                result |= (1 << index);
            }
        }
        if (result > 0x7FFFFFFF) {
            result = ~(result ^ mask);
        }
        return result;
    }
}
