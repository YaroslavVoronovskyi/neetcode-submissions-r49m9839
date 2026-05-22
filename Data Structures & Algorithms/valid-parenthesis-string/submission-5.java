class Solution {
    public boolean checkValidString(String expression) {
        int size = expression.length();
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> star = new LinkedList<>();
        for (int index = 0; index < size; index++) {
            char character = expression.charAt(index);
            if (character == '(') {
                left.push(index);
            } else if (character == '*') {
                star.push(index);
            } else {
                if (left.isEmpty() && star.isEmpty()) {
                    return false;
                }
                if (!left.isEmpty()) {
                    left.pop();
                } else {
                    star.pop();
                }
            }
        
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            if (left.pop() > star.pop()) {
                return false;
            }
        }
        return left.isEmpty();
    }
}
