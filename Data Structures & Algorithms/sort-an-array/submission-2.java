class Solution {
    public int[] sortArray(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1);
        return numbers;
    }

    private void mergeSort(int[] numbers, int left, int right) {
        if (right <= left) {
           return;
        }
        int middle = (left + right) / 2;;
        mergeSort(numbers, left, middle);
        mergeSort(numbers, middle + 1, right);
        merge(numbers, left, middle, right);
    }

    private void merge(int[] numbers, int left, int middle, int right) {
        List<Integer> list = new ArrayList<>();
        int i = left;
        int j = middle + 1;
        while (i <= middle && j <= right) {
            if (numbers[i] <= numbers[j]) {
                list.add(numbers[i]);
                i++;
            } else {
                list.add(numbers[j]);
                j++;
            }
        }
        while (i <= middle) {
            list.add(numbers[i]);
            i++;
        }
        while (j <= right) {
            list.add(numbers[j]);
            j++;
        }
        for (int index = left; index <= right; index++) {
            numbers[index] = list.get(index - left);
        }
    }
}