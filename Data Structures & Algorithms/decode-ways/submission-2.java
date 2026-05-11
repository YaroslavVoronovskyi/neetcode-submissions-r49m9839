class Solution {
    public int numDecodings(String expression) {
        int size = expression.length();
        int[] array = new int[size + 1];
        array[size] = 1;
        for (int index = size - 1; index >= 0; index--) {
            if (expression.charAt(index) == '0') {
                array[index] = 0;
            } else {
                array[index] = array[index + 1];
                if (index + 1 < expression.length() && (expression.charAt(index) == '1' ||
                    expression.charAt(index) == '2' && expression.charAt(index + 1) < '7')) {
                        array[index] += array[index + 2];
                    }
            }
        }
        return array[0];
    }
}
