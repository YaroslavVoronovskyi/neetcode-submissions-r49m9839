class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Pair>> map = new HashMap<>();
        
        for (int index = 0; index < equations.size(); index++) {
            String a = equations.get(index).get(0);
            String b = equations.get(index).get(1);
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(new Pair(b, values[index]));
            map.get(b).add(new Pair(a, 1 / values[index]));     
        }

        double[] result = new double[queries.size()];
        for (int index = 0; index < queries.size(); index++) {
            String src = queries.get(index).get(0);
            String target = queries.get(index).get(1);
            result[index] = breadthFirstSearch(src, target, map);
        }
        return result;
    }

    private double breadthFirstSearch(String src, String target, Map<String, List<Pair>> map) {
        if (!map.containsKey(src) || !map.containsKey(target)) {
            return -1.0;
        }
        
        Queue<Pair> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair(src, 1.0));
        visited.add(src);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String node = current.node;
            double weight = current.weight;

            if (node.equals(target)) {
                return weight;
            }

            for (Pair neighbor : map.get(node)) {
                if (!visited.contains(neighbor.node)) {
                    visited.add(neighbor.node);
                    queue.offer(new Pair(neighbor.node, weight * neighbor.weight));
                }
            }
        }
        return -1.0;
    }

    class Pair {
        public String node;
        public double weight;

        public Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}