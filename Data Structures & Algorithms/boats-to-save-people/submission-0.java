class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
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