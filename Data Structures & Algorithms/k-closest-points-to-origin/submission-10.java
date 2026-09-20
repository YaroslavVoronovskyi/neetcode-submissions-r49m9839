class Solution {
    public int[][] kClosest(int[][] points, int key) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(distanceSquare(b), distanceSquare(a)));
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > key) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[key][2];
        
        for (int index = 0; index < key; index++) {
            result[index] = maxHeap.poll();
        }
        return result;
    }

    private int distanceSquare(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
