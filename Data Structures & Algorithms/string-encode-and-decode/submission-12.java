class Solution {

    public String encode(List<String> expressions) {
        if (expressions.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();
        for (String expression : expressions) {
            sizes.add(expression.length());
        }
        for (int size : sizes) {
            result.append(size).append(',');
        }
        result.append('#');
        for (String expression : expressions) {
            result.append(expression);
        }
        return result.toString();
    }

    public List<String> decode(String expression) {
        if (expression.length() == 0) {
            return List.of();
        }
        List<String> result = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int index = 0;
        while (expression.charAt(index) != '#') {
            StringBuilder current = new StringBuilder();
            while (expression.charAt(index) != ',') {
                current.append(expression.charAt(index));
                index++;
            }
            sizes.add(Integer.parseInt(current.toString()));
            index++;
        }
        index++;
        for (int size : sizes) {
            result.add(expression.substring(index, index + size));
            index += size;
        }    
        return result;
    }
}
