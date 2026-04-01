class Solution {
    public int lastStoneWeight(int[] stones) {
        int maxStone = 0;
        for (int stone : stones) {
            maxStone = Math.max(maxStone, stone);
        }

        int[] bucket = new int[maxStone + 1];
        for (int stone : stones) {
            bucket[stone]++;
        }

        int first = maxStone;
        int second = maxStone;

        while (first > 0) {
            if (bucket[first] % 2 == 0) {
                first--;
                continue;
            }

            int index = Math.min(first - 1, second);
            while (index > 0 && bucket[index] == 0) {
                index--;
            }

            if (index == 0) {
                return first;
            }

            second = index;
            bucket[first]--;
            bucket[second]--;
            bucket[first - second]++;
            first = Math.max(first - second, second);
        }
        return first;
    }
}
