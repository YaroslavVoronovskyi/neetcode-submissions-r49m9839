class Solution {
    public int minEatingSpeed(int[] piles, int hour) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int result = 1;
        while (left <= right) {
            int middle = left + ((right - left) / 2);
            long totalTime = 0;
            for (int pile : piles) {
                totalTime += (int) Math.ceil((double) pile / middle);
            }
            if (totalTime <= hour) {
                result = middle;
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return result;
    }
}
