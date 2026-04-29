class Solution {
    public int[][] kClosest(int[][] points, int key) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] point : points) {
            int distinct = point[0] * point[0] + point[1] * point[1];
            minHeap.offer(new int[]{distinct, point[0], point[1]});
        }

        int[][] result = new int[key][2];
        for (int index = 0; index < key; ++index) {
            int[] point = minHeap.poll();
            result[index] = new int[]{point[1], point[2]};
        }
        return result;
    }
}
