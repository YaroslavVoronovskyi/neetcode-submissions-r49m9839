class Solution {
    public int hammingWeight(int number) {
        int result = 0;
        while (number != 0) {
            result += (number & 1) == 1 ? 1 : 0;
            number >>= 1;
        }
        return result;
    }
}
