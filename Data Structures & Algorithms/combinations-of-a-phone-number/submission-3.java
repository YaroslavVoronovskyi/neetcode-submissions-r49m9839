class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        result.add("");
        String[] digitToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String currentString : result) {
                for (char character : digitToChar[digit - '0'].toCharArray()) {
                    temp.add(currentString + character);
                }
            }
            result = temp;
        }
        return result;
    }
}
