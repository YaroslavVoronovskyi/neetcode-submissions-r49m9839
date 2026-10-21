class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        result.add("");
        String[] digitToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};

        for (char digit : digits.toCharArray()) {
            List<String> temp = new ArrayList<>();
            for (String current : result) {
                for (char character : digitToChar[digit - '0'].toCharArray()) {
                    temp.add(current + character);
                }
            }
            result = temp;
        }
        return result;
    }
}
