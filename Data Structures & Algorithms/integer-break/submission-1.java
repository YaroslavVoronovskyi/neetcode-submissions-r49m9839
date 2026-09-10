class Solution {
    public int integerBreak(int number) {
        return depthFirstSearch(number, number - 1);
    }

    private int depthFirstSearch(int number, int original) {
        if (Math.min(number, original) == 0) {
            return 1;
        }
        if (original > number) {
            return depthFirstSearch(number, number);
        }
        return Math.max(original * depthFirstSearch(number - original, original), depthFirstSearch(number, original - 1));
    }
}