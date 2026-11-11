class Solution {
    public boolean canPartition(int[] numbers) {
        int total = Arrays.stream(numbers).sum();
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        boolean[] cache = new boolean[target + 1];
        cache[0] = true;

        for (int number : numbers) {
            for (int index = target; index >= number; index --){
                cache[index] = cache[index] | cache[index - number];
            }
        }
        return cache[target];
    }
}
