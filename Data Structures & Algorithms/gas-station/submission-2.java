class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int size = gas.length;
        int total = 0;
        int result = 0;
        for (int index = 0; index < size; index++) {
            total += (gas[index] - cost[index]);
            if (total < 0) {
                total = 0;
                result = index + 1;
            }
        }
        return result;
    }
}
