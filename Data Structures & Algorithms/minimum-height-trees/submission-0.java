class Solution {

    private List<List<Integer>> lists;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        lists = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            lists.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }

        int minHgt = n;
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < n; index++) {
            int curHgt = depthFirstSearch(index, -1);
            if (curHgt == minHgt) {
                result.add(index);
            } else if (curHgt < minHgt) {
                result = new ArrayList<>();
                result.add(index);
                minHgt = curHgt;
            }
        }
        return result;
    }

    private int depthFirstSearch(int node, int parent) {
        int hgt = 0;
        for (int nei : lists.get(node)) {
            if (nei == parent) {
                continue;
            }
            hgt = Math.max(hgt, 1 + depthFirstSearch(nei, node));
        }
        return hgt;
    }
}