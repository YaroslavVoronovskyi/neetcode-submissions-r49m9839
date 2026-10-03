class Solution {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int index = 0; index <= size; index++) {
            while (!stack.isEmpty() && (index == size || heights[stack.peek()] >= heights[index])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? index : index - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);

            }
            stack.push(index);
        }
        return maxArea;
    }
}
