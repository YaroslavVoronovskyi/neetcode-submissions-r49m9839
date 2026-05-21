class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean x = false;
        boolean y = false;
        boolean z = false;
        for (int[] item : triplets) {
            x |= (item[0] == target[0] && item[1] <= target[1] && item[2] <= target[2]);
            y |= (item[0] <= target[0] && item[1] == target[1] && item[2] <= target[2]);
            z |= (item[0] <= target[0] && item[1] <= target[1] && item[2] == target[2]);
            if (x && y && z) {
                return true;
            }
        }
        return false;
    }
}
