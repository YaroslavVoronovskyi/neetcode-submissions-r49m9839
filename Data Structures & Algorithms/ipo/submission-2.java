class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minCapital = new PriorityQueue<>((a, b) -> capital[a] - capital[b]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> profits[b] - profits[a]);

        for (int index = 0; index < capital.length; index++) {
            minCapital.offer(index);
        }
        for (int index = 0; index < k; index++) {
            while (!minCapital.isEmpty() && capital[minCapital.peek()] <= w) {
                maxProfit.offer(minCapital.poll());
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            w += profits[maxProfit.poll()];
        }
        return w;
    }
}