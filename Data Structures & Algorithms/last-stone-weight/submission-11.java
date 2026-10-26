class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int size = stones.length;

        while (size > 1) {
            int current = stones[size - 1] - stones[size - 2];
            size -= 2;
            if (current > 0) {
                int left = 0;
                int right = size;
                while (left < right) {
                    int middle = left + (right - left) / 2;
                    if (stones[middle] < current) {
                        left = middle + 1;
                    } else {
                        right = middle;
                    }
                }
                int pos = left;
                size++;
                stones = Arrays.copyOf(stones, size);
                for ( int index = size - 1; index > pos; index--) {
                    stones[index] = stones[index - 1];
                }
                stones[pos] = current;
            } 
        }
        return size > 0 ? stones[0] : 0;
    }
}
