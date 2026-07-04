class Solution {

    private Map<Integer, Integer> dp = new HashMap<>();

    public int tribonacci(int number) {
        if (number <= 2) {
            return number == 0 ? 0 : 1;
        }
        if (dp.containsKey(number)) {
            return dp.get(number);
        }
        dp.put(number, tribonacci(number - 1) + tribonacci(number - 2) + tribonacci(number - 3));
        return dp.get(number);
    }
}