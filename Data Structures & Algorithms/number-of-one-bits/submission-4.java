class Solution {
    public int hammingWeight(int number) {
        int result = 0;
        while (number > 0) {
            result += number & 1;
            number >>= 1;
        }
        return result;
    }
}
