class Solution {
    public boolean isHappy(int number) {
        Set<Integer> visited = new HashSet<>();
        while (!visited.contains(number)) {
            visited.add(number);
            number = sumOfSquares(number);
            if (number == 1) {
                return true;
            }
        }
        return false;
    }

    private int sumOfSquares(int number) {
        int output = 0;
        while (number > 0) {
            int digit = number % 10;
            digit = digit * digit;
            output += digit;
            number /= 10;
        }
        return output;
    }
}
