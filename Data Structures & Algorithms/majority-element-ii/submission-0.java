class Solution {
    public List<Integer> majorityElement(int[] numbers) {
        Set<Integer> result  = new HashSet<>();
        for (int number : numbers) {
            int count = 0;
            for (int index : numbers) {
                if (index == number) {
                    count++;
                }
            }
            if (count > numbers.length / 3) {
                result.add(number);
            }
        }
        return new ArrayList<>(result);
    }
}