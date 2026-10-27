class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        } 
        int max = 0;
        int count = 0;
        for (int x : counts) {
            if (x > max) {
                max = x; 
                count = 1; 
            } else if (x == max) {
                count++;
            } 
        }
        return Math.max(tasks.length, (max - 1 ) * (n + 1) + count);
    }
}
