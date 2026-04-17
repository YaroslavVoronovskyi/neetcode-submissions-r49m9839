class Solution {
    public int findDuplicate(int[] numbers) {
        int[] array = new int[numbers.length];
        for (int number : numbers) {
            if (array[number - 1] == 1) {
                return number;
            }
            array[number - 1] = 1;
        }
        return -1;
    }
}
