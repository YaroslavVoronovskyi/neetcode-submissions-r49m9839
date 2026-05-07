class Solution {

    private List<String> result = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(0, "", digits);
        return result;
    }

    private void backtrack(int index, String current, String digits) {
        if (current.length() == digits.length()) {
            result.add(current);
            return;
        }
        String chars = digitToChar[digits.charAt(index) - '0'];
        for (char character : chars.toCharArray()) {
            backtrack(index + 1, current + character, digits);
        }
    }
}
