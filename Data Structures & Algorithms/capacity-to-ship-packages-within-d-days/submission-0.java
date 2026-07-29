class Solution {
   
    public int shipWithinDays(int[] weights, int days) {
        int result = 0;
        for (int weight : weights) {
            result = Math.max(result, weight);
        }
        while (true) {
            int ships = 1;
            int cap = result;
            for (int weight : weights) {
                if (cap - weight < 0) {
                    ships++;
                    cap = result;
                }
                cap -= weight;
            }
            if (ships <= days) {
                return result;
            }
            result++;
        }
    }
}