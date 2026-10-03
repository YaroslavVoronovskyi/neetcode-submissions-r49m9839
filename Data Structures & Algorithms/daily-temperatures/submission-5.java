class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];
        for (int outer = 0; outer < size; outer++) {
            int count = 1;
            int inner = outer + 1;
            while (size > inner) {
                if (temperatures[outer] < temperatures[inner]) {
                    break;
                }
                inner++;
                count++;
            }
            count = (inner == size) ? 0 : count;
            result[outer] = count;
        }
        return result;
    }
}
