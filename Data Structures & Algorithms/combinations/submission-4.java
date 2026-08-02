class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> comb = new ArrayList<>();
            for (int bit = 0; bit < n; bit++) {
                if ((mask & (1 << bit)) != 0) {
                    comb.add(bit + 1);
                }
            }
            if (comb.size() == k) {
                result.add(comb);
            }
        }
        return result;
    }
}