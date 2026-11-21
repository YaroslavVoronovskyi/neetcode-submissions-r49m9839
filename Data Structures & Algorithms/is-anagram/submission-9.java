class Solution {
    public boolean isAnagram(String expression, String target) {
        if (expression.length() != target.length()) {
            return false;
        }
        
        char[] first = expression.toCharArray();
        char[] second = target.toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        for (int index = 0; index < first.length; index++) {
            if (first[index] != second[index]) {
                return false;
            }
        }
        return true;
    }
}
