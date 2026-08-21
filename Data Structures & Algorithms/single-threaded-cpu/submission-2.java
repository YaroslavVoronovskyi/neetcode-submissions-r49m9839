class Solution {
    public int[] getOrder(int[][] tasks) {
        int size = tasks.length;
        Integer[] indices = new Integer[size];
        for (int index  = 0; index < size; index++) {
            indices[index] = index;
         }
        Arrays.sort(indices, (a, b) -> 
            tasks[a][0] != tasks[b][0] ? tasks[a][0] - tasks[b][0] : a - b);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> 
            tasks[a][1] != tasks[b][1] ? tasks[a][1] - tasks[b][1] : a - b);
        int[] result = new int[size];
        int time = 0;
        int index = 0;
        int resultIndex = 0;
        while (!minHeap.isEmpty() || index < size) {
            while (index < size && tasks[indices[index]][0] <= time) {
                minHeap.offer(indices[index]);
                index++;
            }
            if (minHeap.isEmpty()) {
                time = tasks[indices[index]][0];
            } else {
                int nextIndex = minHeap.poll();
                time += tasks[nextIndex][1];
                result[resultIndex++] = nextIndex;
            }
        }
        return result;
    }
}