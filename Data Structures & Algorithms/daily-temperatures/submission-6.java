class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];
        Stack<int[]> stack = new Stack<>();
        for (int index = 0; index < size; index++) {
            int temperature = temperatures[index];
            while (!stack.isEmpty() && temperature > stack.peek()[0]) {
                int[] pair = stack.pop();
                result[pair[1]] = index - pair[1];
            }
            stack.push(new int[]{temperature, index});
        }
        return result;
    }
}
