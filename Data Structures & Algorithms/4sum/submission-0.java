class Solution {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        int size = numbers.length;
        Arrays.sort(numbers);
        Set<List<Integer>> result = new HashSet<>();

        for (int a = 0; a < size; a++) {
            for (int b = a + 1; b < size; b++) {
                for (int c = b + 1; c < size; c++) {
                    for (int d = c + 1; d < size; d++ ) {
                        if (numbers[a] + numbers[b] + 0L + numbers[c] + numbers[d] == target) {
                            result.add(Arrays.asList(numbers[a], numbers[b], numbers[c], numbers[d]));
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}