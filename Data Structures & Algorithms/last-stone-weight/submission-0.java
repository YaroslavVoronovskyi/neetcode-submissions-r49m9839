class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int stone : stones) {
            stoneList.add(stone);
        }

        while (stoneList.size() > 1) {
            Collections.sort(stoneList);
            int current = stoneList.remove(stoneList.size() - 1) - stoneList.remove(stoneList.size() - 1);
            if (current != 0) {
                stoneList.add(current);
            }
        }
        return stoneList.isEmpty() ? 0 : stoneList.get(0);
    }
}
