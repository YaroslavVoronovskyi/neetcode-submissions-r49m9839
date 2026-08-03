class Solution {

    private Map<Integer, Integer> count;
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] numbers) {
        result = new ArrayList<>();
        count = new HashMap<>();
        List<Integer> perm = new ArrayList<>();
        for (int number : numbers) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        depthFirstSearch(numbers, perm);
        return result;
    }

    private void depthFirstSearch(int[] numbers, List<Integer> perm) {
        if (perm.size() == numbers.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int number : count.keySet()) {
            if (count.get(number) > 0) {
                perm.add(number);
                count.put(number, count.get(number) - 1);
                depthFirstSearch(numbers, perm);
                count.put(number, count.get(number) + 1);
                perm.removeLast();
            }
        }
    }
}