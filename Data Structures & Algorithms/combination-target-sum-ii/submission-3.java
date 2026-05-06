class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private Map<Integer, Integer> count = new HashMap<>(); 
    public List<List<Integer>> combinationSum2(int[] numbers, int target) {
        List<Integer> current = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            if (!count.containsKey(number)) {
                list.add(number);
            }
            count.put(number, count.getOrDefault(number, 0)  +1);
        }
        backtrack(list, target, current, 0);
        return result;
    }

    private void backtrack(List<Integer> numbers, int target, List<Integer> current, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index >= numbers.size()) {
            return;
        }
        if (count.get(numbers.get(index)) > 0) {
            current.add(numbers.get(index));
            count.put(numbers.get(index), count.get(numbers.get(index)) - 1);
            backtrack(numbers, target - numbers.get(index), current, index);
            count.put(numbers.get(index), count.get(numbers.get(index)) + 1);
            current.remove(current.size() - 1);
        }
        backtrack(numbers, target, current, index + 1);
    }
}
