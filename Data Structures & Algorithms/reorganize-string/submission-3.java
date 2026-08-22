class Solution {
    public String reorganizeString(String expression) {
        int[] freq = new int[26];
        for (char character : expression.toCharArray()) {
            freq[character - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int index = 0; index < 26; index++) {
            if (freq[index] > 0) {
                maxHeap.offer(new int[]{freq[index], index});
            }
        }

        StringBuilder result = new StringBuilder();
        int[] prev = null;
        while (!maxHeap.isEmpty() || prev != null) {
            if (prev != null && maxHeap.isEmpty()) {
                return "";
            }
            int[] current = maxHeap.poll();
            result.append((char) (current[1] + 'a'));
            current[0]--;
            if (prev != null) {
                maxHeap.offer(prev);
                prev = null;
            }
            if (current[0] > 0) {
                prev = current;
            }
        }
        return result.toString();
    }
}