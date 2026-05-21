class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] current = new int[3];
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            current[0] = Math.max(current[0], triplet[0]);
            current[1] = Math.max(current[1], triplet[1]);
            current[2] = Math.max(current[2], triplet[2]);
        }
        return current[0] == target[0] && current[1] == target[1] && current[2] == target[2];
    }
}
