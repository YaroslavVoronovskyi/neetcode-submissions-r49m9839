class Solution {

    private boolean[][] array;

    public List<List<String>> partition(String expression) {
        int size = expression.length();
        array = new boolean[size][size];
        for (int left = 1; left <= size; left++) {
            for (int index = 0; index <= size - left; index++) {
                array[index][index + left - 1] = (expression.charAt(index) == expression.charAt(index + left - 1) &&
                                                 (index + 1 > (index + left - 2) || array[index + 1][index + left - 2]));
            }
        }
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
            if (array[i][j]) {
                part.add(expression.substring(i, j + 1));
                depthFirstSearch(j + 1, expression, part, result);
                part.remove(part.size() - 1);
            }
        }
    }
}
