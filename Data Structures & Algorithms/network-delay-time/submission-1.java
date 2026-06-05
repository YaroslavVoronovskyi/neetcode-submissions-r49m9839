class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int inf = Integer.MAX_VALUE / 2;
        int[][] dist = new int[n][n];

        for (int index = 0; index < n; index++) {
            Arrays.fill(dist[index], inf);
            dist[index][index] = 0;
        }

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            dist[u][v] = w;
        }

        for (int mid = 0; mid < n; mid++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][mid] + dist[mid][j]);
                }
            }
        }

        int result = Arrays.stream(dist[k-1]).max().getAsInt();
        return result == inf ? -1 : result;
    }
}
