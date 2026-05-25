class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        int[] result = new int[num1.length() + num2.length()];
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i1 = 0; i1 < num1.length(); i1++) {
            for (int i2 = 0; i2 < num2.length(); i2++) {
                int digit = (num1.charAt(i1) - '0') * (num2.charAt(i2) - '0');
                result[i1 + i2] += digit;
                result[i1 + i2 + 1] += result[i1 + i2] / 10;
                result[i1 + i2] %= 10;
            }
        }
        StringBuilder builder = new StringBuilder();
        int index = result.length - 1;
        while (index >= 0 && result[index] == 0) {
            index--;
        }
        while (index >= 0) {
            builder.append(result[index--]);
        }
        return builder.toString();
    }
}
