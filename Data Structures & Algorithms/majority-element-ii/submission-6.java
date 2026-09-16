class Solution {
    public List<Integer> majorityElement(int[] numbers) {
        int size = numbers.length;
        int number1 = -1;
        int number2 = -1;
        int candidate1 = 0;
        int candidate2 = 0;

        for (int number : numbers) {
            if (number == number1) {
                candidate1++;
            } else if (number == number2) {
                candidate2++;
            } else if (candidate1 == 0) {
                candidate1 = 1;
                number1 = number;
            } else if (candidate2 == 0) {
                candidate2 = 1;
                number2 = number;
            } else {
                candidate1--;
                candidate2--;
            }
        }

        candidate1 = 0;
        candidate2 = 0;
        for (int number : numbers) {
            if (number == number1) {
                candidate1++;
            } else if (number == number2) {
                candidate2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (candidate1 > size / 3) {
            result.add(number1);
        }
        if (candidate2 > size / 3) {
            result.add(number2);
        }
        return result;
    }
}