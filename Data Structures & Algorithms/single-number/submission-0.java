class Solution {
    public int singleNumber(int[] numbers) {
        int size = numbers.length;
        for (int i = 0; i < size; i++) {
            boolean flag = true;
            for (int j = 0; j < size; j++) {
                if (i != j && numbers[i] == numbers[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return numbers[i];
            }
        }
        return -1;
    }
}
