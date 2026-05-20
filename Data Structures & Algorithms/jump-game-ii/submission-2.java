class Solution {
    public int jump(int[] numbers) {
        int size = numbers.length;
        int[] array = new int[size];
        Arrays.fill(array, 1000000);
        array[size - 1] = 0;
      
        for (int i = size - 2; i >= 0; i--) {
            int end = Math.min(size, i + numbers[i] + 1);
            for (int j = i + 1; j < end; j++) {
                array[i] = Math.min(array[i], 1 + array[j]);
            }
        }
        return array[0];
    }
}
