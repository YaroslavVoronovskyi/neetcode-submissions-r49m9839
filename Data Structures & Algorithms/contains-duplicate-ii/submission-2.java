class Solution {
    public boolean containsNearbyDuplicate(int[] numbers, int k) {
        Set<Integer> window = new HashSet<>();
        int left = 0;
        for (int right = 0; right < numbers.length; right++) {
            if (right - left > k) {
                window.remove(numbers[left]);
                left++;
            }
            if (window.contains(numbers[right])) {
                return true;
            }
            window.add(numbers[right]);
        }
        return false;
    }
}