class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> comb) {
        if (comb.size() == k) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int index = start; index <= n; index++) {
            comb.add(index);
            backtrack(index + 1, n, k, comb);
            comb.removeLast();
        }
    }
}