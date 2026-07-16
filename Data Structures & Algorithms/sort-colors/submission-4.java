class Solution {
    public void sortColors(int[] numbers) {
        int zero = 0;
        int one = 0;
        for (int two = 0; two < numbers.length; two++) {
            int temp = numbers[two];
            numbers[two] = 2;
            if (temp < 2) {
                numbers[one++] = 1;
            }  
            if (temp < 1) {
                numbers[zero++] = 0;
            } 
        }
    }
}