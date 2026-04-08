class Solution {
    public int hammingWeight(int number) {
        int result = 0;
        for (int index = 0; index < 32; index++) {
            if ((1 << index & number) != 0) {
                result++;
            }
        }
        return result;
    }
}
