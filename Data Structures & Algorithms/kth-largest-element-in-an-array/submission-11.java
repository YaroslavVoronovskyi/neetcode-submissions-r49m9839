class Solution {
    public int findKthLargest(int[] numbers, int key) {
        Arrays.sort(numbers);
        return numbers[numbers.length - key];
    }
}
