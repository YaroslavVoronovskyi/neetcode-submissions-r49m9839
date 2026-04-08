class Solution {
    public int hammingWeight(int number) {
        int result = 0;
        while (number != 0) {
            number &= number - 1;
            result++;
        }
        return result;
    }
}
