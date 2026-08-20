class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> 
            a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );
        PriorityQueue<int[]> pending = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int size = tasks.length;
        for (int index  = 0; index < size; index++) {
            pending.offer(new int[]{tasks[index][0], tasks[index][1], index});
        }
        long time = 0;
        int idx = 0;
        int[] result = new int[size];
        while (!pending.isEmpty() || !available.isEmpty()) {
            while (!pending.isEmpty() && pending.peek()[0] <= time) {
                int[] task = pending.poll();
                available.offer(new int[]{task[1], task[2]});
            }
            if (available.isEmpty()) {
                time = pending.peek()[0];
                continue;
            }
            int[] task = available.poll();
            time += task[0];
            result[idx++] = task[1];
        }
        return result;
    }
}