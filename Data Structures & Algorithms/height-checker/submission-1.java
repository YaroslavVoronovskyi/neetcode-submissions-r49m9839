class Solution {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int height : heights) {
            count[height]++;
        }

        
        List<Integer> expected = new ArrayList<>();
        for (int h = 1; h <= 100; h++) {
            int c = count[h];
            for (int i = 0; i < c; i++) {
                expected.add(h);
            }
        }

        int result = 0;
        for (int index = 0; index < heights.length; index++) {
            if (heights[index] != expected.get(index)) {
                result++;
            }
        }
        return result;
    }
}