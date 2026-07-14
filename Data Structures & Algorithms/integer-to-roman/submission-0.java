class Solution {
    public String intToRoman(int number) {
        String[][] list = {
            {"I", "1"}, {"IV", "4"}, {"V", "5"}, {"IX", "9"},
            {"X", "10"}, {"XL", "40"}, {"L", "50"}, {"XC", "90"},
            {"C", "100"}, {"CD", "400"}, {"D", "500"}, {"CM", "900"},
            {"M", "1000"} 
        };

        StringBuilder result = new StringBuilder();
        for (int index = list.length - 1; index >= 0; index--) {
            String sum = list[index][0];
            int value = Integer.parseInt(list[index][1]);
            int count = number / value;
            if (count > 0) {
                result.append(sum.repeat(count));
                number %= value;
            }
        }
        return result.toString();
    }
}