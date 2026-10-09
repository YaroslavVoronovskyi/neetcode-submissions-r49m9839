class Solution {
    public int[] maxSlidingWindow(int[] numbers, int k) {
        int size = numbers.length;
        int[] output = new int[size - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        int left = 0;
        int right = 0;

        while (right < size) {
            while (!queue.isEmpty() && numbers[queue.getLast()] < numbers[right]) {
                queue.removeLast();
            }
            queue.addLast(right);
            if (left > queue.getFirst()) {
                queue.removeFirst();
            }
            if ((right + 1) >= k) {
                output[left] = numbers[queue.getFirst()];
                left++;
            }
            right++;
        }
        return output;
    }
}
