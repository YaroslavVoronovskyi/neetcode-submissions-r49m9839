class Solution {
    public int[] getOrder(int[][] tasks) {
        int size = tasks.length;
        for (int index  = 0; index < size; index++) {
            tasks[index] = new int[] {tasks[index][0], tasks[index][1], index};
        }
        Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));
        int[] result = new int[size];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> 
            a[0] ==b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );
        int index = 0;
        int idx = 0;
        long time = tasks[0][0];
        while (!minHeap.isEmpty() || index < size) {
            while (index < size && time >= tasks[index][0]) {
                minHeap.offer(new int[]{tasks[index][1], tasks[index][2]});
                index++;
            }
            if (minHeap.isEmpty()) {
                time = tasks[index][0];
            } else {
                int[] task = minHeap.poll();
                time += task[0];
                result[idx++] = task[1];
            }
        }
        return result;
    }
}