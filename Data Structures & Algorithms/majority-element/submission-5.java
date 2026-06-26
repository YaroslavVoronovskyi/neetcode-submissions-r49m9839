class Solution {
    public int majorityElement(int[] numbers) {
        Random random = new Random();
        int size = numbers.length;
        while (true) {
            int candidate = numbers[random.nextInt(size)];
            int count = 0;
            for (int number : numbers) {
                if (number == candidate) {
                    count++;
                }
            }
            if (count > size / 2) {
                return candidate;
            }
        }
    }
}