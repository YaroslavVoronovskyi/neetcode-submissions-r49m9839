class Solution {
    public String longestPalindrome(String expression) {
        int[] result = manacher(expression);
        int resLen = 0;
        int middle = 0;
        for (int index = 0; index < result.length; index++) {
            if (result[index] > resLen) {
                resLen = result[index];
                middle = index;
            }
        }
        int resIdx = (middle - resLen) / 2;
        return expression.substring(resIdx, resIdx + resLen);
    }

    private int[] manacher(String expression) {
        StringBuilder builder = new StringBuilder("#");
        for (char character : expression.toCharArray()) {
            builder.append(character).append("#");
        }
        int size = builder.length();
        int[] result = new int[size];
        int left = 0;
        int right = 0;
        for (int index = 0; index < size; index++) {
            result[index] = (index < right) ? Math.min(right - index, result[left + (right - index)]) : 0;
            while (index + result[index] + 1 < size && index - result[index] - 1 >= 0 &&
                   builder.charAt(index + result[index] + 1) == builder.charAt(index - result[index] - 1)) {
                result[index]++;
            }
            if (index + result[index] > right) {
                left = index - result[index];
                right = index + result[index];
            }
        }
        return result;
    }
}
