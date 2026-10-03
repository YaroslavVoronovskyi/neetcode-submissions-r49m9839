class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int size = position.length;
        int[][] pairs = new int[size][2];
        for (int index = 0; index < size; index++) {
            pairs[index][0] = position[index];
            pairs[index][1] = speed[index];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] pair : pairs) {
            stack.push((double) (target - pair[0]) / pair[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }
}
