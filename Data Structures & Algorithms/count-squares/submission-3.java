class CountSquares {
    private Map<Integer, Map<Integer, Integer>> count;

    public CountSquares() {
        count = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        count.putIfAbsent(x, new HashMap<>());
        count.get(x).put(y, count.get(x).getOrDefault(y, 0) + 1);

    }
    
    public int count(int[] point) {
        int result = 0;
        int x1 = point[0];
        int y1 = point[1];
        if (!count.containsKey(x1)) {
            return result;
        }
        for (int y2 : count.get(x1).keySet()) {
            int side = y2 - y1;
            if (side == 0) {
                continue;
            }
            int x3 = x1 + side;
            int x4 = x1 - side;
            result += count.get(x1).get(y2) * count.getOrDefault(x3, new HashMap<>()).getOrDefault(y1, 0) * count.getOrDefault(x3, new HashMap<>()).getOrDefault(y2, 0);
            result += count.get(x1).get(y2) * count.getOrDefault(x4, new HashMap<>()).getOrDefault(y1, 0) * count.getOrDefault(x4, new HashMap<>()).getOrDefault(y2, 0);
        }
        return result;
    }
}
