class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        StringBuilder sa = new StringBuilder(a).reverse();
        StringBuilder sb = new StringBuilder(b).reverse();
        for (int index = 0; index < Math.max(sa.length(), sb.length()); index++) {
            int digitA = index < sa.length() ? sa.charAt(index) - '0' : 0;
            int digitB = index < sb.length() ? sb.charAt(index) - '0' : 0;
            int total = digitA + digitB + carry;
            char character = (char)((total % 2) + '0');
            result.append(character);
            carry = total / 2; 
        }
        if (carry > 0) {
            result.append('1');
        }
        return result.reverse().toString(); 
    }
}