class Solution {
    public void sortColors(int[] numbers) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] == 0) {
                numbers[two++] = 2;
                numbers[one++] = 1;
                numbers[zero++] = 0;
            } else if (numbers[index] == 1) {
                numbers[two++] = 2;
                numbers[one++] = 1;
            } else {
                numbers[two++] = 2;
            }
        }
    }
}