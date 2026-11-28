class Solution {
    public int calPoints(String[] operations) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();
        for (String operation : operations) {
            if (operation.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                score += newTop;
            } else if (operation.equals("D")) {
                stack.push(2 * stack.peek());
                score += stack.peek();
            } else if (operation.equals("C")) {
                score -= stack.pop();
            } else {
                stack.push(Integer.parseInt(operation));
                score += stack.peek();
            }
        }
        return score;
    }
}