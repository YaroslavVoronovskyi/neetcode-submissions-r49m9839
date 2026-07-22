class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int m = Arrays.stream(people).max().getAsInt();
        int[] count = new int[m + 1];
        for (int p : people) {
            count[p]++;
        }
        int idx = 0;
        int i = 1;
        while (idx < people.length) {
            while (count[i] == 0) {
                i++;
            }
            people[idx++] = i;
            count[i]--;
        }
        int result = 0;
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            int remain = limit - people[right--];
            result++;
            if (left <= right && remain >= people[left]) {
                left++;
            }
        }
        return result;
    }
}