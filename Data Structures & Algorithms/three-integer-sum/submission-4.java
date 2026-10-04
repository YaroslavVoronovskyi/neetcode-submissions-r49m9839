class Solution {
    public List<List<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] > 0) {
                break;
            }
            if (index > 0 && numbers[index] == numbers[index - 1]) {
                continue;
            }
            int left = index + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[index] + numbers[left] + numbers[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(numbers[index], numbers[left], numbers[right]));
                    left++;
                    right--;
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
