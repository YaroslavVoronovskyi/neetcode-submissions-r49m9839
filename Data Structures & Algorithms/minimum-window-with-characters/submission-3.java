class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char character : t.toCharArray()) {
            countT.put(character, countT.getOrDefault(character, 0) + 1);
        } 

        int current = 0;
        int target = countT.size();
        int[] result = {-1, -1};
        int resultLength = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char character = s.charAt(right);
            window.put(character, window.getOrDefault(character, 0) + 1);
            if (countT.containsKey(character) && window.get(character).equals(countT.get(character))) {
                current++;
            }
            while (current == target) {
                if ((right - left + 1) < resultLength) {
                    resultLength = right - left + 1;
                    result[0] = left;
                    result[1] = right;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    current--;
                }
                left++;
            }
        }
        return resultLength == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}
