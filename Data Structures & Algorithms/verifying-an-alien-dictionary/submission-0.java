class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];
        for (int index = 0; index < order.length(); index++) {
            orderIndex[order.charAt(index) - 'a'] = index;
        }
        Comparator<String> compare = (w1, w2) -> {
            for (int index = 0; index < Math.min(w1.length(), w2.length()); index++) {
                if (w1.charAt(index) != w2.charAt(index)) {
                    return orderIndex[w1.charAt(index) - 'a'] - orderIndex[w2.charAt(index) - 'a'];
                }
            }
            return w1.length() - w2.length();
        };
        String[] sortedWords = words.clone();
        Arrays.sort(sortedWords, compare);
        return Arrays.equals(words, sortedWords);
    }
}