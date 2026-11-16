class Solution {
    public int reverseBits(int number) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < 32; index++) {
            if ((number & (1 << index)) != 0) {
                builder.append("1");
            } else {
                builder.append("0");
            }
        }
        int result = 0;
        String reverse = builder.reverse().toString();
        for (int index = 0; index < 32; index++) {
            if (reverse.charAt(index) == '1') {
                result |= (1 << index);
            }
        }
        return result;
    }
}
