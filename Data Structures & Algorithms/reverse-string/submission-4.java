class Solution {
    public void reverseString(char[] s) {
        List<Character> list = new ArrayList<>();
        for (char character : s) {
            list.add(character);
        }
        Collections.reverse(list);
        for (int index = 0; index < s.length; index++) {
            s[index] = list.get(index);
        }
    }
}