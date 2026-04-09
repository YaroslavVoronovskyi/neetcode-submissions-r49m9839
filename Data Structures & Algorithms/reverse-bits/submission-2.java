class Solution {
    public int reverseBits(int number) {
        int result = number;
        result = result >>> 16 | result << 16;
        result = (result & 0xff00ff00) >>> 8 | (result & 0x00ff00ff) << 8;
        result = (result & 0xf0f0f0f0) >>> 4 | (result & 0x0f0f0f0f) << 4;
        result = (result & 0xcccccccc) >>> 2 | (result & 0x33333333) << 2;
        result = (result & 0xaaaaaaaa) >>> 1 | (result & 0x55555555) << 1;
        return result;
    }
}
