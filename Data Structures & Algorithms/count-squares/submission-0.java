class CountSquares {

    private Map<List<Integer>, Integer> map;
    private List<List<Integer>> list;

    public CountSquares() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> points = Arrays.asList(point[0], point[1]);
        map.put(points, map.getOrDefault(points, 0) + 1);
        list.add(points);
    }
    
    public int count(int[] point) {
        int result = 0;
        int px = point[0];
        int py = point[1];
        for (List<Integer> pt : list) {
            int x = pt.get(0);
            int y = pt.get(1);
            if (Math.abs(py - y) != Math.abs(px - x) || x == px || y == py) {
                continue;
            }
            result += map.getOrDefault(Arrays.asList(x, py), 0) *
                      map.getOrDefault(Arrays.asList(px, y), 0);
        }
        return result;
    }
}
