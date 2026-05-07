class Solution {

    

    public List<List<String>> partition(String expression) {
        int size = expression.length();
        boolean[][] array = new boolean[size][size];
        for (int left = 1; left <= size; left++) {
            for (int index = 0; index <= size - left; index++) {
                array[index][index + left - 1] = (expression.charAt(index) == expression.charAt(index + left - 1) &&
                                                 (index + 1 > (index + left - 2) || 
                                                 array[index + 1][index + left - 2]));
            }
        }
        return depthFirstSearch(expression, array, 0);
    }

    private List<List<String>> depthFirstSearch(String expression, boolean[][] array, int i) {
        if (i >= expression.length()) {
            return new ArrayList<List<String>>() {
                {
                    add(new ArrayList<>());
                }
            };
        }
        List<List<String>> result = new ArrayList<>();
        for (int j = i; j < expression.length(); j++) {
            if (array[i][j]) {
                List<List<String>> next = depthFirstSearch(expression, array, j + 1);
                for (List<String> part : next) {
                    List<String> current = new ArrayList<>();
                    current.add(expression.substring(i, j + 1));
                    current.addAll(part);
                    result.add(current);
                }
            }
        }
        return result;
    }
}
