class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> count1 = new HashMap<>();
        for (char character : s1.toCharArray()) {
            count1.put(character, count1.getOrDefault(character, 0) + 1);
        }

        int target = count1.size();
        for (int i = 0; i < s2.length(); i++) {
            Map<Character, Integer> count2 = new HashMap<>();
            int current = 0;
            for (int j = i; j < s2.length(); j++) {
                char character = s2.charAt(j);
                count2.put(character, count2.getOrDefault(character, 0) + 1);
                if (count1.getOrDefault(character, 0) < count2.get(character)) {
                    break;
                }
                if (count1.getOrDefault(character, 0) == count2.get(character)) {
                    current++;
                }
                if (current == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
