class Solution {
    public int removeElement(int[] numbers, int val) {
        List<Integer> result = new ArrayList<>();
        for (int number : numbers) {
            if (number != val) {
                result.add(number);
            }
        }
        for (int index = 0; index < result.size(); index++) {
            numbers[index] = result.get(index);
        }
        return result.size();
    }
}