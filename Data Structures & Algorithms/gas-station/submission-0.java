class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int size = gas.length;
        for (int i = 0; i < size; i++) {
            int tank = gas[i] - cost[i];
            if (tank < 0) {
                continue;
            }
            int j = (i + 1) % size;
            while (j != i) {
                tank += gas[j] - cost[j];
                if (tank < 0) {
                    break;
                }
                j = (j + 1) % size;
            }
            if (j == i) {
                return i;
            }
        }
        return -1;
    }
}
