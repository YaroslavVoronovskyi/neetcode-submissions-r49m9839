class Solution {
    public void sortColors(int[] numbers) {
        int[] counts = new int[3];
        for (int number : numbers) {
           counts[number]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (counts[i]-- > 0) {
                numbers[index++] = i;
            }
        }
    }
}