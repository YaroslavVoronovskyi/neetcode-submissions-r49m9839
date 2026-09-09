class Solution {
   
    public int shipWithinDays(int[] weights, int days) {
        int result = 0;
        for (int weight : weights) {
            result = Math.max(result, weight);
        }
        while (true) {
            int ships = 1;
            int capacity = result;
            for (int weight : weights) {
                if (capacity - weight < 0) {
                    ships++;
                    capacity = result;
                }
                capacity -= weight;
            }
            if (ships <= days) {
                return result;
            }
            result++;
        }
    }
}