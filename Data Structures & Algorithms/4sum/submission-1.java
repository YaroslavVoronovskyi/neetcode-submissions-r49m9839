class Solution {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        int size = numbers.length;
        Arrays.sort(numbers);
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : numbers) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            count.put(numbers[i], count.get(numbers[i]) - 1);
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                count.put(numbers[j], count.get(numbers[j]) - 1);
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < size; k++) {
                    count.put(numbers[k], count.get(numbers[k]) - 1);
                    if (k > j + 1 && numbers[k] == numbers[k - 1]) {
                        continue;
                    }
                    long fourth = target - (numbers[i] + numbers[j] + 0L + numbers[k]);
                    if (fourth > Integer.MAX_VALUE || fourth < Integer.MIN_VALUE) {
                        continue;
                    }
                    if (count.getOrDefault((int) fourth, 0) > 0) {
                        result.add(Arrays.asList(numbers[i], numbers[j], numbers[k], (int) fourth));
                    }
                }
                for (int k = j + 1; k < size; k++) {
                    count.put(numbers[k], count.get(numbers[k]) + 1);
                }
            }
            for (int j = i + 1; j < size; j++) {
                count.put(numbers[j], count.get(numbers[j]) + 1);
            }
        }
        return result;
    }
}