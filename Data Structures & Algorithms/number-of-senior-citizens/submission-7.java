class Solution {
    public int countSeniors(String[] details) {
        int result = 0;
        for (String detail : details) {
            int ten = detail.charAt(11) - '0';
            int one = detail.charAt(12) - '0';
            int age = one + 10 * ten;
            if (age > 60) {
                result++;
            }
        }
        return result;
    }
}