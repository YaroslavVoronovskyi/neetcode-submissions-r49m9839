class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        String result = "";
        int zero = 0;
        for (int index = num2.length() - 1; index >= 0; index--) {
            String current = mul(num1, num2.charAt(index), zero);
            result = add(result, current);
            zero++;
        }
        return result;
    }

    private String mul(String expression, char item, int zero) {
        int i = expression.length() - 1;
        int carry = 0;
        int digit = item - '0';
        StringBuilder current = new StringBuilder();
        while (i >= 0 || carry > 0) {
            int n = (i >= 0) ? expression.charAt(i) - '0' : 0;
            int prod = n * digit + carry;
            current.append(prod % 10);
            carry = prod / 10;
            i--;
        }
        return current.reverse().toString() + "0".repeat(zero);
    }

    private String add(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int total = n1 + n2 + carry;
            result.append(total % 10);
            carry = total / 10;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}
