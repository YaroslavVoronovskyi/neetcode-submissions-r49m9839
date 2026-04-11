class Solution {
    public int findMin(int[] numbers) {
        return Arrays.stream(numbers).min().getAsInt();
    }
}
