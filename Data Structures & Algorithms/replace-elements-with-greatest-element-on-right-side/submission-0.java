class Solution {
    public int[] replaceElements(int[] array) {
        int size = array.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int rightMax = -1;
            for (int j = i + 1; j < size; j++) {
                rightMax = Math.max(rightMax, array[j]);
            }
            result[i] = rightMax;
        }
        return result;
    }
}