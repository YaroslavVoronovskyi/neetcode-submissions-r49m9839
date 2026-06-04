class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int size = edges.length;
        int[] par = new int[size + 1];
        int[] rank = new int[size + 1];
        for (int index = 0; index < size + 1; index++) {
            par[index] = index;
            rank[index] = 1;
        }
        for (int[] edge : edges) {
            if (!union(par, rank, edge[0], edge[1])) {
                return new int[]{edge[0], edge[1]};
            }
        }
        return new int[0];
    }

    private int find(int[] par, int n) {
        int p = par[n];
        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    private boolean union(int[] par, int[] rank, int n1, int n2) {
        int p1 = find(par, n1);
        int p2 = find(par, n2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
