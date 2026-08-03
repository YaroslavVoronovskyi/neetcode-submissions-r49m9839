class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] numbers) {
        result = new ArrayList<>();
        Arrays.sort(numbers);
        depthFirstSearch(0, numbers);
        return result;
    }

    private void depthFirstSearch(int index, int[] numbers) {
        if (index == numbers.length) {
            List<Integer> temp = new ArrayList<>();
            for (int number : numbers) {
                temp.add(number);
            }
            result.add(temp);
            return;
        }
        for (int j = index; j < numbers.length; j++) {
            if (j > index && numbers[j] == numbers[index]) {
               continue; 
            }
            swap(numbers, index, j);
            depthFirstSearch(index + 1, numbers);
        }
        for (int j = numbers.length - 1; j > index; j--) {
            swap(numbers, index, j);
        }
    }

    private void swap(int[] numbers, int index, int j) {
        int temp = numbers[index];
        numbers[index] = numbers[j];
        numbers[j] = temp;
    }
}