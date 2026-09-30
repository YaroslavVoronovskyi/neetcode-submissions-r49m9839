class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int result = size;

        int index = 1;
        while (index < size) {
            if (ratings[index] == ratings[index - 1]) {
                index++;
                continue;
            }

            int inc = 0;
            while (index < size && ratings[index] > ratings[index - 1]) {
                inc++;
                result += inc;
                index++;
            }

            int dec = 0;
            while (index < size && ratings[index] < ratings[index - 1]) {
                dec++;
                result += dec;
                index++;
            }
            result -= Math.min(inc, dec);
        }
        return result;
    }
    
}