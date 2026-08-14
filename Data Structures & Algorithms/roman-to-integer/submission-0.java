class Solution {
    public int romanToInt(String expression) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('X', 10);
        roman.put('C', 100);
        roman.put('M', 1000);
        roman.put('V', 5);
        roman.put('L', 50);
        roman.put('D', 500);

        int result = 0;
        for (int index  = 0; index < expression.length(); index++) {
            if (index + 1 < expression.length() && roman.get(expression.charAt(index)) < roman.get(expression.charAt(index + 1))) {
                result -= roman.get(expression.charAt(index));
            } else {
                result += roman.get(expression.charAt(index));
            }
        }
        return result;
    }
}