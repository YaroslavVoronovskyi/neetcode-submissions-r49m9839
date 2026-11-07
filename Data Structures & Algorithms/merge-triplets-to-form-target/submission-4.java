class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();
        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }
            for ( int index = 0; index < triplet.length; index++) {
                if (triplet[index] == target[index]) {
                    good.add(index);
                }
            }
        }
        return good.size() == 3;
    }
}
