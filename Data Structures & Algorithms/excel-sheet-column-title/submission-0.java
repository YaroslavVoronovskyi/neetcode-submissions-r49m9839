class Solution {

    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }
        int number = columnNumber - 1;
        return convertToTitle(number / 26) + (char) ('A' + number % 26);
    }
}