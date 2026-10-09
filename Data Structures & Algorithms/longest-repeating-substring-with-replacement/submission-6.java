class Solution {
    public int characterReplacement(String expression, int k) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for(char character : expression.toCharArray()) {
            set.add(character);
        }

        for (char character : set) {
            int count = 0;
            int left = 0;
            for (int right = 0; right < expression.length(); right++) {
                if (expression.charAt(right) == character) {
                    count++;
                }
                while ((right - left + 1) - count > k) {
                    if (expression.charAt(left) == character) {
                        count--;
                    }
                    left++;
                }
                result = Math.max(result, right - left + 1);
            }
        }
        return result;
    }
}
