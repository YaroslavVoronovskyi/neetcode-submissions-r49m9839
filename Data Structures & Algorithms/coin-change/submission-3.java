class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] isSeen = new boolean[amount + 1];
        isSeen[0] = true;
        int result = 0;

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                int current = queue.poll();
                for (int coin : coins) {
                    int next = current + coin;
                    if (next == amount) {
                        return result;
                    }
                    if (next > amount || isSeen[next]) {
                        continue;
                    }
                    isSeen[next] = true;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
