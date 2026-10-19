class Solution {
    public int heightChecker(int[] heights) {
        int result = 0;
        int[] expected = new int[heights.length];
        for (int index = 0; index < heights.length; index++) {
            expected[index] = heights[index];
        }
        Arrays.sort(expected);
        for (int index = 0; index < heights.length; index++) {
            if (heights[index] != expected[index]) {
                result++;
            }
        }
        return result;
    }
}