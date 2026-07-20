class Solution {

    private List<List<Integer>> result;
    private List<Integer> quad;

    public List<List<Integer>> fourSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        result = new ArrayList<>();
        quad = new ArrayList<>();
        kSum(numbers, 4, 0, target);
        return result;
    }

    private void kSum(int[] numbers, int k, int start, long target) {
        if (k == 2) {
            int left = start;
            int right = numbers.length - 1;
            while (left < right) {
                long sum = numbers[left] + numbers[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    result.add(new ArrayList<>(quad));
                    result.get(result.size() - 1).add(numbers[left]);
                    result.get(result.size() - 1).add(numbers[right]);
                    left++;
                    right--;
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                }
            }
            return;
        }
        for (int i = start; i < numbers.length - k + 1; i++) {
            if (i > start && numbers[i] == numbers[i - 1]) {
                continue;
            }
            quad.add(numbers[i]);
            kSum(numbers, k - 1, i + 1, target - numbers[i]);
            quad.remove(quad.size() - 1);
        }
    }
}