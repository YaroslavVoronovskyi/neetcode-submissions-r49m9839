class Solution {

    private List<List<String>> result = new ArrayList<>();
    private List<String> part = new ArrayList<>();

    public List<List<String>> partition(String expression) {
        depthFirstSearch(0, 0, expression);
        return result;
    }

    private void depthFirstSearch(int j, int i, String expression) {
        if (i >= expression.length()) {
            if (i == j) {
                result.add(new ArrayList<>(part));
            }
            return;
        }
        if (isPalindrome(expression, j, i)) {
            part.add(expression.substring(j, i + 1));
            depthFirstSearch(i + 1, i + 1, expression);
            part.remove(part.size() - 1);
        }
        depthFirstSearch(j, i + 1, expression);
    }

    private boolean isPalindrome(String expression, int left, int right) {
        while (left < right) {
            if (expression.charAt(left) != expression.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
