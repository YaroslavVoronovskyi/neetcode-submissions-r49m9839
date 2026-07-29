class Solution {
   
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        int result = right;
        while (left <= right) {
            int cap = (left + right) / 2;
            if (canShip(weights, days, cap)) {
                result = Math.min(result, cap);
                right = cap - 1;
            } else {
                left = cap + 1;
            }
        }
        return result;
    }

    private boolean canShip(int[] weights, int days, int cap) {
        int ships = 1;
        int currentCap = cap;
        for (int weight : weights) {
            if (currentCap - weight < 0) {
                ships++;
                if (ships > days) {
                    return false;
                }
                currentCap = cap;
            }
            currentCap -= weight;
        }
        return true;
    }
}