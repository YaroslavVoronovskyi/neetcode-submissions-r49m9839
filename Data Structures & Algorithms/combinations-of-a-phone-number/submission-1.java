class Solution {

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        result.add("");
        String[] digitToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        
         for (char digit : digits.toCharArray()) {
            List<String> current = new ArrayList<>();
            for (String expression : result) {
                for (char character : digitToChar[digit - '0'].toCharArray()) {
                    current.add(expression + character);
                }
            }
            result = current;
        }
        return result;
    }
}
