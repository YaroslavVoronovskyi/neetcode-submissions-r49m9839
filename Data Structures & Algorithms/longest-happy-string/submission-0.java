class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[] count = {a, b, c};
        StringBuilder result = new StringBuilder();
        int repeated = -1;
        while (true) {
            int maxChar = getMax(count, repeated);
            if (maxChar == -1) {
                break;
            }
            result.append((char) (maxChar + 'a'));
            count[maxChar]--;
            if (result.length() > 1 && result.charAt(result.length() - 1) == result.charAt(result.length() - 2)) {
                repeated = maxChar;
            } else {
                repeated = -1;
            }
        }
        return result.toString();
    }

    private int getMax(int[] count, int repeated) {
        int idx = -1;
        int maxCount = 0;
        for (int index = 0; index < 3; index++) {
            if (index == repeated || count[index] == 0) {
                continue;
            }
            if (maxCount < count[index]) {
                maxCount = count[index];
                idx = index;
            }
        }
        return idx;
    }
}