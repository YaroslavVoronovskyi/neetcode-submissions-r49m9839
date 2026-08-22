class Solution {
    public String reorganizeString(String expression) {
        int[] freq = new int[26];
        for (char character : expression.toCharArray()) {
            freq[character - 'a']++;
        }

        int maxIdx = 0;
        for (int index = 1; index < 26; index++) {
            if (freq[index] > freq[maxIdx]) {
                maxIdx = index;
            }
        }

        int maxFreq = freq[maxIdx];
        if (maxFreq > (expression.length() + 1) / 2) {
            return "";
        }
        char[] result = new char[expression.length()];
        int idx = 0;
        char maxChar = (char) (maxIdx + 'a');
        while (freq[maxIdx] > 0) {
            result[idx] = maxChar;
            idx += 2;
            freq[maxIdx]--;
        }
        for (int index = 0; index < 26; index++) {
            while (freq[index] > 0) {
                if (idx >= expression.length()) {
                    idx = 1;
                }
                result[idx] = (char) (index + 'a');
                idx += 2;
                freq[index]--;
            }
        }
        return new String(result);
    }
}