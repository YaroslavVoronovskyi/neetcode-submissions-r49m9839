class Solution {
    public int reverseBits(int number) {
        StringBuilder binary = new StringBuilder();
        for (int index = 0; index < 32; index++) {
            if ((number & (1 << index)) != 0) {
                binary.append("1");
            } else {
                binary.append("0");
            }
        }
        int result = 0;
        String reversedBinary = binary.reverse().toString();
        for (int index = 0; index < 32; index++) {
            if (reversedBinary.charAt(index) == '1') {
                result |= (1 << index);
            }
        }
        return result;
    }
}
