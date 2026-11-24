class Solution {
    public int[] sortArray(int[] numbers) {
        int outer;
        int inner;
        for (outer = 1; outer < numbers.length; outer++) {
            int temp = numbers[outer];
            inner = outer;
            while  (inner > 0 && numbers[inner - 1] >= temp) {
                numbers[inner] = numbers[inner - 1];
                --inner;
            }
            numbers[inner] = temp;
        }
        return numbers;
    }
}