class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            int count = 1;
            int j = i + 1;
            while (j < size) {
                if (temperatures[j] > temperatures[i]) {
                    break;
                }
                j++;
                count++;
            }
            count = j == size ? 0 : count;
            result[i] = count;
        }
        return result;
    }
}
