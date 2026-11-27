class Solution {
    public void reverseString(char[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
    
}