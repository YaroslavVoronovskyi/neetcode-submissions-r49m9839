class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : hand) {
            count.put(number, count.getOrDefault(number, 0) + 1);
        }
        Arrays.sort(hand);
        for (int number : hand) {
            if (count.get(number) > 0) {
                for (int index = number; index < number + groupSize; index++) {
                    if (count.getOrDefault(index, 0) == 0) {
                        return false;
                    }
                    count.put(index, count.get(index) - 1);
                }
            }
        }
        return true;
    }
}
