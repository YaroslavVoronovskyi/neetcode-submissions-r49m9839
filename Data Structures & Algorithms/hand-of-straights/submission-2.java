class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int number : hand) {
            count.put(number, 1 + count.getOrDefault(number, 0));
        }
        Queue<Integer> queue = new LinkedList<>();
        int lastNumber = -1;
        int openGroup = 0;
        for (int number : count.keySet()) {
            if ((openGroup > 0 && number > lastNumber + 1) || openGroup > count.get(number)) {
                return false;
            }
            queue.add(count.get(number) - openGroup);
            lastNumber = number;
            openGroup = count.get(number);
            if (queue.size() == groupSize) {
                openGroup -= queue.poll();
            }
        }
        return openGroup == 0;
    }
}
