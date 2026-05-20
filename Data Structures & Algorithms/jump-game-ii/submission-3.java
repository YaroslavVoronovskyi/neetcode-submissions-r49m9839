class Solution {
    public int jump(int[] numbers) {
        int result = 0;
        int left = 0;
        int right = 0;
        
        while (right < numbers.length - 1) {
            int farthest = 0;
            for (int index = left; index <= right; index++) {
               farthest = Math.max(farthest, index + numbers[index]);
            }
            left = right + 1;
            right = farthest;
            result++;
        }
        return result;
    }
}
