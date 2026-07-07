class Solution {

    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int offset = columnNumber % 26;
            result.append((char) ('A' + offset));
            columnNumber /= 26;
        }
        return result.reverse().toString();
    }
}