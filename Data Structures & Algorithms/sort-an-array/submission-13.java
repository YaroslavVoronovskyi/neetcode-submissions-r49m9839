class Solution {
    public int[] sortArray(int[] numbers) {
        mergeSort(0, numbers.length - 1, numbers);
        return numbers;
    }

    private void mergeSort(int left, int right, int[] numbers) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(left, middle, numbers);
        mergeSort(middle + 1, right, numbers);
        merge(left, middle, right, numbers);
    }
    
    private void merge(int left, int middle, int right, int[] numbers) {
        List<Integer> temp = new ArrayList<>();
        int i = left;
        int j = middle + 1;
        while (i <= middle && j <= right) {
            if (numbers[i] < numbers[j]) {
                temp.add(numbers[i]);
                i++;
            } else {
                temp.add(numbers[j]);
                j++;
            }
        }
        while (i <= middle) {
            temp.add(numbers[i]);
            i++;
        }
        while (j <= right) {
            temp.add(numbers[j]);
            j++;
        }
        for (i = left; i <= right; i++) {
            numbers[i] = temp.get(i - left);
        }
    }
}