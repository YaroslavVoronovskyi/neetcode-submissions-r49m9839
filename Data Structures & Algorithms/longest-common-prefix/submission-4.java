class Solution {
    public String longestCommonPrefix(String[] strs) {
        for (int index = 0; index < strs[0].length(); index++) {
            for (String word : strs) {
                if (index == word.length() || word.charAt(index) != strs[0].charAt(index)) {
                    return word.substring(0, index);
                }
            }
        }
        return strs[0];
    }
}