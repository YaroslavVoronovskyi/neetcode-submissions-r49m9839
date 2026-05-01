class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        List<int[]> array = new ArrayList<>();
        for (int index = 0; index < 26; index++) {
            if (count[index] > 0) {
                array.add(new int[]{count[index], index});
            }
        }

        int time = 0;

        List<Integer> processed = new ArrayList<>();
        while (!array.isEmpty()) {
            int maxIndex = -1;
            for (int i = 0; i < array.size(); i++) {
                boolean isOk = true;
                for (int j = Math.max(0, time - n); j < time; j++) {
                    if (j < processed.size() && processed.get(j) == array.get(i)[1]) {
                        isOk = false;
                        break;
                    }
                }
                if (!isOk) {
                    continue;
                }
                if (maxIndex == -1 || array.get(maxIndex)[0] < array.get(i)[0]) {
                    maxIndex = i;
                }
            }
            time++;
            int current = -1;
            if (maxIndex != -1) {
                current = array.get(maxIndex)[1];
                array.get(maxIndex)[0]--;
                if (array.get(maxIndex)[0] == 0) {
                    array.remove(maxIndex);
                }
            }
            processed.add(current);
        }
        return time;
    }
}
