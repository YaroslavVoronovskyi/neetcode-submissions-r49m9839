class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int size = stoneValue.length;
        int[] cache = new int[4];

        for (int i = size - 1; i >= 0; i--) {
            int total = 0;
            cache[i % 4] = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(i + 3, size); j++) {
                total += stoneValue[j];
                cache[i % 4] = Math.max(cache[i % 4], total - cache[(j + 1) % 4]);
            }
        }
        if (cache[0] == 0) {
            return "Tie";
        }
        return cache[0] > 0 ? "Alice" : "Bob";
    }
}