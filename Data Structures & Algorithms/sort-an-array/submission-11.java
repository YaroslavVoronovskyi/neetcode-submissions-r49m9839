class Solution {
    public int[] sortArray(int[] numbers) {
        int size = numbers.length;
        int outer;
        int inner;
        int temp;
        
        int h = 1;
        while (h <= size / 3) {
            h = h * 3 + 1; 
        }
        while (h > 0) {            
            for (outer = h; outer < size; outer++) {
                temp = numbers[outer];
                inner = outer;
                while (inner > h - 1 && numbers[inner - h] >= temp) {
                    numbers[inner] = numbers[inner - h];
                    inner -= h;
                }
                numbers[inner] = temp;
            }
            h = (h - 1) / 3;
        }
        return numbers;
    }
}