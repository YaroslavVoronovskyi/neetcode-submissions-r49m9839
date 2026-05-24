class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int top = 0;
        int bottom = matrix.length;
        int right = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        
        while (left < right && top < bottom) {
            for (int index = left; index < right; index++) {
                result.add(matrix[top][index]);
            }
            top++;
            for (int index = top; index < bottom; index++) {
                result.add(matrix[index][right - 1]);
            }
            right--;
            if (!(left < right && top < bottom)) {
                break;
            }
            for (int index = right - 1; index >= left; index--) {
                result.add(matrix[bottom - 1][index]);
            }
            bottom--;
            for (int index = bottom - 1; index >= top; index--) {
                result.add(matrix[index][left]);
            }
            left++;
        }
        return result;
    }
}
