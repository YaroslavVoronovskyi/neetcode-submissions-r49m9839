class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    private void backtrack(int i, int n, int k, List<Integer> comb) {
        if (i > n) {
            if (comb.size() == k) {
                result.add(new ArrayList<>(comb));
            }
            return;
        }
        comb.add(i);
        backtrack(i + 1, n, k, comb);
        comb.removeLast();
        backtrack(i + 1, n, k, comb);
    }
}