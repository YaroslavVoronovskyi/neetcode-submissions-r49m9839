class Solution {
    public int firstMissingPositive(int[] numbers) {
        int missing = 1;
        while (true) {
            boolean flag = true;
            for (int number : numbers) {
                if (missing == number) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return missing;
            }
            missing++;
        }
    }
}