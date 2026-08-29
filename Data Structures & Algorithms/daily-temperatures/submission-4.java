class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < size; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > stack.peek()[0]) {
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{temperature, i});
        }
        return result;
    }
}
