class Solution {
    public int maxTurbulenceSize(int[] array) {
        int size = array.length;
        int result = 0;
        int count = 0;
        int sign = -1;

        for (int index = 0; index < size - 1; index++) {
            if (array[index] > array[index + 1]) {
                count = (sign == 0) ? count + 1 : 1;
                sign = 1;
            } else if (array[index] < array[index + 1]) {
                count = (sign == 1) ? count + 1 : 1;
                sign = 0;
            } else {
                count = 0;
                sign = -1;
            }
            result = Math.max(result, count);
        }
        return result + 1;
    }
}