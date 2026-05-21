class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] current = new int[3];
        for (int index = 0; index < triplets.length; index++) {
            if (triplets[index][0] > target[0] || triplets[index][1] > target[1] || triplets[index][2] > target[2]) {
                continue;
            }
            current[0] = Math.max(current[0], triplets[index][0]);
            current[1] = Math.max(current[1], triplets[index][1]);
            current[2] = Math.max(current[2], triplets[index][2]);
        }
        return current[0] == target[0] && current[1] == target[1] && current[2] == target[2];
    }
}
