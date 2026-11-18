class CountSquares {

    private Map<List<Integer>, Integer> count;
    private List<List<Integer>> points;

    public CountSquares() {
        count = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> list = Arrays.asList(point[0], point[1]);
        count.put(list, count.getOrDefault(list, 0) + 1);
        points.add(list);

    }
    
    public int count(int[] point) {
        int result = 0;
        int px = point[0];
        int py = point[1];
        for (List<Integer> pt : points) {
            int x = pt.get(0);
            int y = pt.get(1);
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) {
                continue;
            }
            result += count.getOrDefault(Arrays.asList(x, py), 0) * count.getOrDefault(Arrays.asList(px , y), 0);
        }
        return result;
    }
}
