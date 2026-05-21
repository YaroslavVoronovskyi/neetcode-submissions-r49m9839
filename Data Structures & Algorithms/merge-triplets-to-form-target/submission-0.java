class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();
        for (int[] item : triplets) {
            if(item[0] > target[0] || item[1] > target[1] || item[2] > target[2]) {
                continue;
            }
            for (int index = 0; index < item.length; index++) {
                if (item[index] == target[index]) {
                    good.add(index);
                }
            }
        }
        return good.size() == 3;
    }
}
