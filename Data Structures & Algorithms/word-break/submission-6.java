class Solution {

    public boolean wordBreak(String expression, List<String> wordDictionary) {
        int size = expression.length();
        boolean[] cache = new boolean[size + 1];
        cache[size] = true;
        for (int index = size - 1; index >= 0; index--) {
            for (String word : wordDictionary) {
                if ((index + word.length()) <= size && expression.substring(index, index + word.length()).equals(word)) {
                    cache[index] = cache[index + word.length()];
                }
                if (cache[index]) {
                    break;
                }
            }
        }
        return cache[0];
    }
}
