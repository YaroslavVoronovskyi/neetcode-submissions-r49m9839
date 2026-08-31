class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        List<Integer> curRow = new ArrayList<>(Arrays.asList(1));
        List<Integer> prevRow = getRow(rowIndex - 1);
        for(int index = 1; index < rowIndex; index++) {
            curRow.add(prevRow.get(index - 1) + prevRow.get(index));
        }
        curRow.add(1);
        return curRow;
    }
}