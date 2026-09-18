class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            char sc = s.charAt(index);
            char tc = t.charAt(index);
            if ((mapST.containsKey(sc) && mapST.get(sc) != tc) ||
                (mapTS.containsKey(tc) && mapTS.get(tc) != sc)) {
                return false;
            }
            mapST.put(sc, tc);
            mapTS.put(tc, sc);
        }
        return true;
    }
}