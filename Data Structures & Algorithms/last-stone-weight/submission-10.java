class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);

        }

        while (list.size() > 1) {
            Collections.sort(list);
            int current = list.remove(list.size() - 1) - list.remove(list.size() - 1);
            if (current != 0) {
                list.add(current);
            } 
        }
        return list.isEmpty() ? 0 : list.get(0);
    }
}
