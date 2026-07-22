class Solution {
    public void rotate(int[] numbers, int k) {
        int size = numbers.length;
        k %= size;
        int count = 0;
        for (int start = 0; count < size; start++) {
            int current = start;
            int prev = numbers[start];
            do {
                int nextIdx = (current + k) % size;
                int temp = numbers[nextIdx];
                numbers[nextIdx] = prev;
                prev = temp;
                current = nextIdx;
                count++;
            } while (start != current);
        }
    }
}