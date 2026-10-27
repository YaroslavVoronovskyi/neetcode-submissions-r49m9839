class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int item : count) {
            if (item > 0) {
                maxHeap.offer(item);
            }
        }

        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        while (!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = queue.peek()[1];
            } else {
                int item = maxHeap.poll() - 1;
                if (item > 0) {
                    queue.add(new int[]{item, time + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] == time) {
                maxHeap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
