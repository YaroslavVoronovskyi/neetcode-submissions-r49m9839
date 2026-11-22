class Solution {
    public int majorityElement(int[] numbers) {
        int size = numbers.length;
        for (int number : numbers) {
            int count = 0;
            for (int item : numbers) {
                if (item == number) {
                    count++;
                }
            }
            if (count > size / 2) {
                return number;
            }
        }
        return -1;
    }
}