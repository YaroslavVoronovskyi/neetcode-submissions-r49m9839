class Solution {
    public int[] sortArray(int[] numbers) {
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        for (int number : numbers) {
            if (number < 0) {
                negatives.add(-number);
            } else {
                positives.add(number);
            }
        }
        if (!negatives.isEmpty()) {
            radixSort(negatives);
            Collections.reverse(negatives);
            for (int index = 0; index < negatives.size(); index++) {
                negatives.set(index, -negatives.get(index));
            }
        }
        if (!positives.isEmpty()) {
            radixSort(positives);
        }
        int index = 0;
        for (int number : negatives) {
            numbers[index++] = number;
        }
        for (int number : positives) {
            numbers[index++] = number;
        }
        return numbers;
    }

    private void countSort(List<Integer> array, int size, int index) {
        int[] count = new int[10];
        for (int number : array) {
            count[(number / index) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        List<Integer> result = new ArrayList<>(Collections.nCopies(size, 0));
        for (int i = size - 1; i >= 0; i--) {
            int idx = (array.get(i) / index) % 10;
            result.set(count[idx] - 1, array.get(i));
            count[idx]--;
        }
        for (int i = 0; i < size; i++) {
            array.set(i, result.get(i));
        }
    }

    private void radixSort(List<Integer> array) {
        int size = array.size();
        int maxElement = Collections.max(array);
        int index = 1;
        while (maxElement / index > 0) {
            countSort(array, size, index);
            index *= 10;
        } 
    }
}