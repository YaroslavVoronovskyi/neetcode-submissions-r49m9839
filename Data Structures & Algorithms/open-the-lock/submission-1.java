class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> visit = new HashSet<>(Arrays.asList(deadends));
        if (visit.contains("0000")) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visit.add("0000");
        int turns = 0;
        while (!queue.isEmpty()) {
            turns++;
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                String lock = queue.poll();
                for (int j = 0; j < 4; j++) {
                    for (int move : new int[]{1, -1}) {
                        char[] array = lock.toCharArray();
                        array[j] = (char)((array[j] - '0' + move + 10) % 10 + '0');
                        String nextLock = new String(array);
                        if (visit.contains(nextLock)) {
                            continue;
                        }
                        if (nextLock.equals(target)) {
                            return turns;
                        }
                        queue.offer(nextLock);
                        visit.add(nextLock);
                    }
                }
            }
        }
        return -1;
    }
}