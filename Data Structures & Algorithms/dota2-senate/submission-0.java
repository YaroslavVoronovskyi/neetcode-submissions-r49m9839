class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();

        int size = senate.length();

        for (int index = 0; index < size; index++) {
            if (senate.charAt(index) == 'R') {
                first.add(index);
            } else {
                second.add(index);
            }
        }

        while (!first.isEmpty() && !second.isEmpty()) {
            int firstTurn = first.poll();
            int secondTurn = second.poll();

            if (firstTurn < secondTurn) {
                first.add(firstTurn + size);
            } else {
                second.add(secondTurn + size);
            }
        }
        return first.isEmpty() ? "Dire" : "Radiant";
    }
}