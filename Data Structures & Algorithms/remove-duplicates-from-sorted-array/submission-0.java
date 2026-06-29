class Solution {
    public int removeDuplicates(int[] numbers) {
        Set<Integer> uniqe = new TreeSet<>();
        for (int number : numbers) {
            uniqe.add(number);
        }
        int index = 0;
        for (int number : uniqe) {
            numbers[index++]  = number;
        }
        return uniqe.size();
    }
}