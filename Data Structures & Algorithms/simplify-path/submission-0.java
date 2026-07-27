class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char character : (path + "/").toCharArray()) {
            if (character == '/') {
                if (current.toString().equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!current.toString().equals("") && !current.toString().equals(".")) {
                    stack.push(current.toString());
                }
                current.setLength(0);
            } else {
                current.append(character);
            }
        } 
        return "/" + String.join("/", stack);
    }
}