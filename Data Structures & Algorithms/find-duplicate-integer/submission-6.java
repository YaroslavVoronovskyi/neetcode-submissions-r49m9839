class Solution {
    public int findDuplicate(int[] numbers) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = numbers[slow];
            fast = numbers[numbers[fast]];
            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            slow = numbers[slow];
            slow2 = numbers[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
    }
}
