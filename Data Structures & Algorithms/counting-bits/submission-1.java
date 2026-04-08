class Solution {
    public int[] countBits(int number) {
        int[] result = new int[number + 1];
        for (int index = 1; index <= number; index++) {
            int num = index;
            while (num != 0) {
                result[index]++;
                num &= (num - 1);
            }
        }
        return result;
    }
}
