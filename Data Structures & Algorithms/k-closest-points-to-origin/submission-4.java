class Solution {
    public int[][] kClosest(int[][] points, int key) {
        int left = 0;
        int right = points.length - 1;
        int size = points.length;
      
        while (size != key) {
            size = partition(points, left, right);
            if (size < key) {
                left = size + 1;
            } else {
                right = size - 1;
            }
        }

        int[][] result = new int[key][2];
        System.arraycopy(points, 0, result, 0, key);
        return result;
    }

    private int partition(int[][] points, int left, int right) {
        int pivotIdx = right;
        int pivotDistinct = euclidean(points[pivotIdx]);
        int i = left;
        for (int j = left; j < right; j++) {
            if (euclidean(points[j]) <= pivotDistinct) {
                int[] temp = points[i];
                points[i] = points[j];
                points[j] = temp;
                i++;
            }
        }
        int[] temp = points[i];
        points[i] = points[right];
        points[right] = temp;
        return i;
    }

    private int euclidean(int[] points) {
        return points[0] * points[0] + points[1] * points[1];
    }
}
