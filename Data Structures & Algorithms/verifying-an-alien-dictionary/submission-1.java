class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderIndex = new int[26];
        for (int index = 0; index < order.length(); index++) {
            orderIndex[order.charAt(index) - 'a'] = index;
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int j = 0;
            for (; j < w1.length(); j++) {
                if (j == w2.length()) {
                    return false;
                }
                if (w1.charAt(j) != w2.charAt(j)) {
                    if (orderIndex[w1.charAt(j) - 'a'] > orderIndex[w2.charAt(j) - 'a']) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}