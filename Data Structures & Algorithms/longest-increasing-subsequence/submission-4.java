class Solution {

    public int lengthOfLIS(int[] numbers) {
        int size = numbers.length;
        List<Integer> list = new ArrayList();
        list.add(numbers[0]);
        int result = 1;
        for (int index = 1; index < size; index++) {
            if (list.get(list.size() - 1) < numbers[index]) {
                list.add(numbers[index]);
                result++;
                continue;
            }
            int idx = Collections.binarySearch(list, numbers[index]);
            if (idx < 0) {
                idx = -idx - 1;
            }
            list.set(idx, numbers[index]);
        }
        return result;
    }
}
