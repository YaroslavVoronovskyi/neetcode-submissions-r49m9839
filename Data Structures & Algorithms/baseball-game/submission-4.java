class Solution {
    public int calPoints(String[] operations) {
        int[] array = new int[operations.length];
        int action = 0;
        for(int index = 0; index < operations.length; index++) {
            if (operations[index].equals("+")) {
                array[action] = array[action - 1] + array[action - 2];
                action++;
            } else if (operations[index].equals("D")) {
                array[action] = 2 * array[action - 1];
                action++;
            } else if (operations[index].equals("C")) {
                action--;
            } else {
                array[action] = Integer.parseInt(operations[index]);
                action++;
            }
        }
        int sum = 0;
        for (int index = 0; index < action; index++) {
            sum += array[index];
        }
        return sum;
    }
}