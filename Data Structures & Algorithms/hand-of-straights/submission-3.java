class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : hand) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        for (int number : hand) {
            int start = number;
            while (count.getOrDefault(start - 1, 0) > 0) {
                start--;
            }
            while (start <= number) {
                while (count.getOrDefault(start, 0) > 0) {
                    for (int index = start; index < start + groupSize; index++) {
                        if (count.getOrDefault(index, 0) == 0) {
                            return false;
                        }
                        count.put(index, count.get(index) - 1);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
