class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        return Arrays.copyOfRange(points, 0, k);

    }
}
