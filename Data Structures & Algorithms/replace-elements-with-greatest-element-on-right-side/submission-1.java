class Solution {
    public int[] replaceElements(int[] array) {
        int size = array.length;
        int[] result = new int[size];
        int rightMax = -1;
        for (int index = size - 1; index >= 0; index--) {
            result[index] = rightMax;
            rightMax = Math.max(rightMax, array[index]);
        }
        return result;
    }
}