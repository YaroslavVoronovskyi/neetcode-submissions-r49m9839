class Solution {
    public int numDecodings(String expression) {
        int size = expression.length();
        int first = 0;
        int second = 1;
        int third = 0;
        for (int index = size - 1; index >= 0; index--) {
            if (expression.charAt(index) == '0') {
                first = 0;
            } else {
                first = second;
                if (index + 1 < size && (expression.charAt(index) == '1' || 
                    expression.charAt(index) == '2' && expression.charAt(index + 1) < '7')) {
                    first += third;
                }
            }
            third = second;
            second = first;
            first = 0;
        }
        return second;
    }
}
