class Solution {
    public List<Integer> findClosestElements(int[] array, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for (int number : array) {
            list.add(number);
        }
        list.sort((a, b) -> {
            int diff = Math.abs(a - x) - Math.abs(b - x);
            return diff == 0 ? Integer.compare(a, b) : diff;
        });
        List<Integer> result = list.subList(0, k);
        Collections.sort(result);
        return result;
    }
}