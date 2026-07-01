class Solution {
    public int calPoints(String[] operations) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (String operation : operations) {
            if (operation.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                result += newTop;
            } else if (operation.equals("D")) {
                stack.push(2 * stack.peek());
                result += stack.peek();
            } else if (operation.equals("C")) {
                result -= stack.pop();
            } else {
                stack.push(Integer.parseInt(operation));
                result += stack.peek();
            }
        }
        return result;
    }
}