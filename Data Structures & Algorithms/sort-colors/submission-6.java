class Solution {
    public void sortColors(int[] numbers) {
        int size = numbers.length;
        int outer;
        int inner;
        int min;
        for (outer = 0; outer < size - 1; outer++) {
            min = outer;
            for (inner = outer + 1; inner < size; inner++) {
                if (numbers[inner] < numbers[min]) {
                    min = inner;
                }
            }
            swap(numbers, outer, min);
        }
    }

    private void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }
}