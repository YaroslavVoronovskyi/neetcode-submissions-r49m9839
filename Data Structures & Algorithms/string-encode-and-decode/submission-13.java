class Solution {

    public String encode(List<String> expressions) {
        if (expressions.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String expression : expressions) {
            result.append(expression.length())
                  .append('#')
                  .append(expression);
        }
        return result.toString();
    }

    public List<String> decode(String expression) {
        if (expression.length() == 0) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < expression.length()) {
            int j = index;
            while (expression.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(expression.substring(index, j));
            index = j + 1;
            j = index + length;
            result.add(expression.substring(index, j));
            index = j;
        }   
        return result;
    }
}
