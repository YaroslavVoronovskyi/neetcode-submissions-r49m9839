class Solution {

    public List<List<Integer>> permuteUnique(int[] numbers) {
        int size = numbers.length;
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        result.add(toList(numbers));

        while (true) {
            int left = size - 2;
            while (left >= 0 && numbers[left] >= numbers[left + 1]) {
                left--;
            }
            if (left < 0) {
                break;
            }
            int right = size - 1;
            while (numbers[right] <= numbers[left]) {
                right--;
            }
            swap(numbers, left, right);
            reverse(numbers, left + 1, size - 1);
            result.add(toList(numbers));
        }
        return result;
    }

    private void reverse(int[] numbers, int left, int right) {
        while (left < right) {
            swap(numbers, left++, right--);
        }
    }

    private void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }

    private List<Integer> toList(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        return list;
    }
}