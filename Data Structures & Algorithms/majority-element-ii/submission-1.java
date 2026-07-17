class Solution {
    public List<Integer> majorityElement(int[] numbers) {
        Arrays.sort(numbers);
        List<Integer> result  = new ArrayList<>();
        int size = numbers.length;
        int i = 0;
        while (i < size) {
            int j = i + 1;
            while (j < size && numbers[i] == numbers[j]) {
                j++;
            }
            if (j - i > size / 3) {
                result.add(numbers[i]);
            }
            i = j;
        }
        return new ArrayList<>(result);
    }
}