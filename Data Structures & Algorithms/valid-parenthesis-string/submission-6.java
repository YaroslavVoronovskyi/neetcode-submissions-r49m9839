class Solution {
    public boolean checkValidString(String expression) {
        int leftMin = 0;
        int leftMax = 0;

        for (char character : expression.toCharArray()) {
            if (character == '(') {
                leftMin++;
                leftMax++;
            } else if (character == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) {
                return false;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}
