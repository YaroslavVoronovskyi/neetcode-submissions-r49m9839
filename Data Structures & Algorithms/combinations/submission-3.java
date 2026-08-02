class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] comb = new int[k];
        int i = 0;
        while (i >= 0) {
            comb[i]++;
            if (comb[i] > n) {
                i--;
                continue;
            }
            if (i == k - 1) {
                List<Integer> current = new ArrayList<>();
                for (int number : comb) {
                    current.add(number);
                }
                result.add(current);
            } else {
                i++;
                comb[i] = comb[i - 1];
            }
        }
        return result;
    }
}