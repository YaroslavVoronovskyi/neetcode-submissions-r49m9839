class Solution {
    public boolean isAnagram(String expression, String target) {
        char[] first = expression.toCharArray();
        char[] second = target.toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        return Arrays.equals(first, second);
    }
}
