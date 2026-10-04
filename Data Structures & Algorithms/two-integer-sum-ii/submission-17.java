class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        for (int index = 0; index < numbers.length; index++) {
            int left = index + 1;
            int right = numbers.length - 1;
            int temp = target - numbers[index];
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (numbers[middle] == temp) {
                    return new int[]{index + 1, middle + 1};
                } else if (numbers[middle] < temp) {
                    left = middle +1;
                } else {
                    right = middle - 1;
                }
            } 
        }
        return new int[0]; 
    }
}
