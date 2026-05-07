class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] numbers) {
        if (numbers.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        backtrack(new ArrayList<>(), numbers, 0);
        return result;
    }

    private void backtrack(List<Integer> perm, int[] numbers, int mask) {
        if (perm.size() == numbers.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int index = 0; index < numbers.length; index++) {
            if ((mask & (1 << index)) == 0) {
                perm.add(numbers[index]);
                backtrack(perm, numbers, mask | (1 << index));
                perm.remove(perm.size() - 1);
            }
        }
    } 
}
