class Solution {

    public List<List<Integer>> subsetsWithDup(int[] numbers) {
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int prevIndex = 0;
        int index = 0;

        for (int i = 0; i < numbers.length; i++) {
            index = (i >= 1 && numbers[i] == numbers[i - 1]) ? prevIndex : 0;
            prevIndex = result.size();
            for (int j = index; j < prevIndex; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(numbers[i]);
                result.add(temp);
            }
        }
        return result;
    }
}
