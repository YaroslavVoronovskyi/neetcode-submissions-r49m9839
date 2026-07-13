class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n + 1];
        int[] outgoing = new int[n + 1];

        for (int[] item : trust) {
            outgoing[item[0]]++;
            incoming[item[1]]++;
        } 
        for (int index = 1; index <= n; index++) {
            if (outgoing[index] == 0 && incoming[index] == n - 1) {
                return index;
            }
        }
        return -1;
    }
}