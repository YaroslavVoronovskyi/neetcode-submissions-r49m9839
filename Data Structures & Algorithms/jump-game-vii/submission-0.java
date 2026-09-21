class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int farthest = 0;
        int size = s.length();

        while (!queue.isEmpty()) {
            int index = queue.poll();
            int start = Math.max(index + minJump, farthest + 1);
            for (int j = start; j < Math.min(index + maxJump + 1, size); j++) {
                if (s.charAt(j) == '0') {
                    queue.add(j);
                    if (j == size - 1) {
                        return true;
                    }
                }
            }
            farthest = index + maxJump;
        }
        return false;
    }
}