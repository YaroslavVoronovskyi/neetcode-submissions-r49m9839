class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int n = 0; n < numRows; n++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            int value = 1;
            for (int k = 1; k <= n; k++) {
                value = value * (n - k + 1) / k;
                row.add(value);
            }
            result.add(row);
        }
        return result;
    }
}