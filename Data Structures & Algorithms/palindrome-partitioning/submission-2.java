class Solution {

    public List<List<String>> partition(String expression) {
        List<List<String>> result = new ArrayList<>();
        List<String> part = new ArrayList<>();
        depthFirstSearch(0, expression, part, result);
        return result;
    }

    private void depthFirstSearch(int i, String expression, List<String> part, List<List<String>> result) {
        if (i >= expression.length()) {
            result.add(new ArrayList<>(part));
            return;
        }
        for (int j = i; j < expression.length(); j++) {
            if (isPalindrome(expression, i, j)) {
                part.add(expression.substring(i, j + 1));
                depthFirstSearch(j + 1, expression, part, result);
                part.remove(part.size() - 1);
            }
        }
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
