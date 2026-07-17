class Solution {
    public List<Integer> majorityElement(int[] numbers) {
        int size = numbers.length;
        int number1 = -1;
        int number2 = -1;
        int count1 = 0;
        int count2 = 0;
        for (int number : numbers) {
            if (number == number1) {
                count1++;
            } else if (number == number2) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                number1 = number;
            } else if (count2 == 0) {
                count2 = 1;
                number2 = number;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int number : numbers) {
            if (number == number1) {
                count1++;
            } else if (number == number2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > size / 3) {
            result.add(number1);
        }
        if (count2 > size / 3) {
            result.add(number2);
        }
        return result;
    }
}