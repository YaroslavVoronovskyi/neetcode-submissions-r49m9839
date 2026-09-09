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
            int capacity = left + ((right - left) / 2);
            if (canShip(weights, days, capacity)) {
                result = Math.min(result, capacity);
                right = capacity - 1;
            } else {
                left = capacity + 1;
            }
        }
        return result;
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int ships = 1;
        int currentCapacity = capacity;
        for (int weight : weights) {
            if (currentCapacity - weight < 0) {
                ships++;
                if (ships > days) {
                    return false;
                }
                currentCapacity = capacity;
            }
            currentCapacity -= weight;
        }
        return true;
    }
}