class Solution {
    public String reorganizeString(String expression) {
        int[] freq = new int[26];
        for (char character : expression.toCharArray()) {
            freq[character - 'a']++;
        }

        int maxFreq = Arrays.stream(freq).max().getAsInt();
        if (maxFreq > (expression.length() + 1) / 2) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        while (result.length() < expression.length()) {
            int maxIdx = findMaxIndex(freq);
            char maxChar = (char) (maxIdx + 'a');
            result.append(maxChar);
            freq[maxIdx]--;
            if (freq[maxIdx] == 0) {
                continue;
            }
            int temp = freq[maxIdx];
            freq[maxIdx] = Integer.MIN_VALUE;
            int nextMaxIdx = findMaxIndex(freq);
            char nextMaxChar = (char) (nextMaxIdx + 'a');
            result.append(nextMaxChar);
            freq[maxIdx] = temp;
            freq[nextMaxIdx]--;
        }
        return result.toString();
    }

    private int findMaxIndex(int[] freq) {
        int maxIdx = 0;
        for (int index = 1; index < freq.length; index++) {
            if (freq[index] > freq[maxIdx]) {
                maxIdx = index;
            }
        }
        return maxIdx;
    }
}