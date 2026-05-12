class Solution {

    public boolean canPartition(int[] numbers) {
        int size = numbers.length;
        if (Arrays.stream(numbers).sum() % 2 != 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int target = Arrays.stream(numbers).sum() / 2;

        for (int index = size - 1; index >= 0; index--) {
            Set<Integer> next = new HashSet<>();
            for (int item : set) {
                if (item + numbers[index] == target) {
                    return true;
                }
                next.add(item + numbers[index]);
                next.add(item);
            }
            set = next;
        }
        return false;
    }
}
