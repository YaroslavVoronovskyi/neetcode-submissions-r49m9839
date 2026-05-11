class Solution {

    public boolean wordBreak(String expression, List<String> wordDictionary) {
        boolean[] array = new boolean[expression.length() + 1];
        array[expression.length()] = true;
        for (int index = expression.length() - 1; index >= 0; index--) {
            for (String word : wordDictionary) {
                if ((index + word.length()) <= expression.length() && 
                    expression.substring(index, index + word.length()).equals(word)) {
                        array[index] = array[index + word.length()];
                    }
                if (array[index]) {
                    break;
                }
            }
        }
        return array[0];
    }
}
