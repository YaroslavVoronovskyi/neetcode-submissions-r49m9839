class Solution {
    

    public List<List<String>> partition(String expression) {
        List<List<String>> result = new ArrayList<>();
        List<String> part = new ArrayList<>();
        backtrack(0, expression, part, result);
        return result;
    }

    private void backtrack(int index, String expression, List<String> part, List<List<String>> result) {
        if (index >= expression.length()) {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int j = index; j < expression.length(); j++) {
            if (isPalindrome(expression, index, j)) {
                part.add(expression.substring(index, j + 1));
                backtrack(j + 1, expression, part, result);
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
