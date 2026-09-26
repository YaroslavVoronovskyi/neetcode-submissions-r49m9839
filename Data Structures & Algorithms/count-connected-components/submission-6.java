class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int result = n; 
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                result--;
            }
        }
        return result;
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int index = 0; index < n; index++) {
            parent[index] = index;
            rank[index] = 1;
        }
    }

    public int find(int node) {
        int current = node;
        while (current != parent[current]) {
            parent[current] = parent[parent[current]];
            current = parent[current];
        }
        return current;
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        if (rank[pv] > rank[pu]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }
}
