class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int size = nums.length;
        UnionFind unionFind = new UnionFind(size);
        Map<Integer, Integer> factorIndex = new HashMap<>();

        for (int index = 0; index < size; index++) {
            int number = nums[index];
            int factor = 2;
            while (factor * factor <= number) {
                if (number % factor == 0) {
                    if (factorIndex.containsKey(factor)) {
                        unionFind.union(index, factorIndex.get(factor));
                    } else {
                        factorIndex.put(factor, index);
                    }
                    while (number % factor == 0) {
                        number /= factor;
                    }
                }
                factor++;
            }
            if (number > 1) {
                if (factorIndex.containsKey(number)) {
                    unionFind.union(index, factorIndex.get(number));
                } else {
                    factorIndex.put(number, index);
                }
            }
        }
        return unionFind.isConnected();
    }
}

class UnionFind {
    private int n;
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {
        this.n = n;
        this.parent = new int[n + 1];
        this.size = new int[n + 1];
        for (int index = 0; index <= n; index++) {
            this.parent[index] = index;
            this.size[index] = 1;
        }
    }

    public int find(int node) {
        if(parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        n--;
        if (size[pu] < size[pv]) {
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        size[pu] += size[pv];
        parent[pv] = pu;
        return true;
    }

    public boolean isConnected() {
        return n == 1;
    }
}