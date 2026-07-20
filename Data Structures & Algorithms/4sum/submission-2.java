class Solution {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        int size = numbers.length;
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = size - 1;
                while (left < right) {
                    long sum = (long) numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum == target) {
                        result.add(Arrays.asList(numbers[i], numbers[j], numbers[left], numbers[right]));
                        left++;
                        right--;
                        while (left < right && numbers[left] == numbers[left - 1]) {
                            left++;
                        }
                        while (left < right && numbers[right] == numbers[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}