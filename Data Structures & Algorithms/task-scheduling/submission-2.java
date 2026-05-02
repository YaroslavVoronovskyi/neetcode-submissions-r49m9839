class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        Arrays.sort(count);
        int maxf = count[25];
        int idle = (maxf - 1) * n;

        for (int index = 24; index >= 0; index--) {
            idle -= Math.min(maxf - 1, count[index]);
        }
        return Math.max(0, idle) + tasks.length;
    }
}
