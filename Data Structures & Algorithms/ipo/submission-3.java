class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int size = profits.length;
        Integer[] indices = new Integer[size];
        for (int index = 0; index < size; index++) {
            indices[index] = index;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(capital[a], capital[b]));
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for (int index = 0; index < k; index++) {
            while (idx < size && capital[indices[idx]] <= w) {
                maxProfit.add(profits[indices[idx]]);
                idx++;
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            w += maxProfit.poll();
        }
        return w;
    }
}