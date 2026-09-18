class Solution {

    public boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }

    private boolean helper(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char sc = s.charAt(index);
            char tc = t.charAt(index);
            if (map.containsKey(sc) && map.get(sc) != tc) {
                return false;
            }
            map.put(sc, tc);
        }
        return true;
    }
}