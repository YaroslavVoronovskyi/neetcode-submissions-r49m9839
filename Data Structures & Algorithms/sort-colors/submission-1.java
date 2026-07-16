class Solution {
    public void sortColors(int[] numbers) {
        int[] count = new int[3];
        for (int number : numbers) {
            count[number]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (count[i]-- > 0) {
                numbers[index++] = i;
            }
        }
    }
}