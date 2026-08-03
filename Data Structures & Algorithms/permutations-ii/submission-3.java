class Solution {

    private boolean[] visit;
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] numbers) {
        result = new ArrayList<>();
        visit = new boolean[numbers.length];
        Arrays.sort(numbers);
        List<Integer> perm = new ArrayList<>();
        depthFirstSearch(numbers, perm);
        return result;
    }

    private void depthFirstSearch(int[] numbers, List<Integer> perm) {
        if (perm.size() == numbers.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int index = 0; index < numbers.length; index++) {
            if (visit[index] || (index > 0 && numbers[index] == numbers[index -1] && !visit[index -1])) {
               continue; 
            }
            visit[index] = true;
            perm.add(numbers[index]);
            depthFirstSearch(numbers, perm);
            visit[index] = false;
            perm.removeLast();
        }
    }
}