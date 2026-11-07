class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean isXSatisfied = false;
        boolean isYSatisfied = false; 
        boolean isZSatisfied = false;

        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            if (triplet[0] == target[0]) {
                isXSatisfied = true;
            }

            if (triplet[1] == target[1]) {
                isYSatisfied = true;
            }

            if (triplet[2] == target[2]) {
                isZSatisfied = true;
            }

            if (isXSatisfied && isYSatisfied && isZSatisfied) {
                return true;
            }
        }
        return false;
    }
}
