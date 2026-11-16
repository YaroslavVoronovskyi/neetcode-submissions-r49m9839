class Solution {
    public int reverse(int number) {
        int result = 0;
        int digit = 0;
        while(number != 0){
            digit = number % 10;
            if(result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10){
                return 0;
            }
            result = result * 10 + digit;
            number /= 10;
        }
        return result;
    }
}
