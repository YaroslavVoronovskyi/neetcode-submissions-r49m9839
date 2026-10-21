class Solution {
    private List<List<String>> result = new ArrayList<>();
    private List<String> part = new ArrayList<>();

    public List<List<String>> partition(String expression) {
        backtrack(0, 0, expression);
        return result;
    }

    private void backtrack(int j, int i, String expression) {
        if (i >= expression.length()) {
            if (i == j) {
                result.add(new ArrayList<>(part));
            }
            return;
        }

        if (isPalindrome(expression, j, i)) {
            part.add(expression.substring(j, i + 1));
            backtrack(i + 1, i + 1, expression);
            part.remove(part.size() - 1);
        }
        backtrack(j, i + 1, expression);
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
