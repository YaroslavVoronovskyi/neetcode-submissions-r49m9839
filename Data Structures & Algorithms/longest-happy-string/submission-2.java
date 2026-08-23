class Solution {
    public String longestDiverseString(int a, int b, int c) {   
        return String.join("", recursion(a, b, c, 'a', 'b', 'c'));
    }

    private List<String> recursion(int max1, int max2, int max3, char char1, char char2, char char3) {
        if (max1 < max2) {
            return recursion(max2, max1, max3, char2, char1, char3);
        }
        if (max2 < max3) {
            return recursion(max1,  max3, max2, char1, char3, char2);
        }
        if (max2 == 0) {
            List<String> result = new ArrayList<>();
            for (int index = 0; index < Math.min(2, max1); index++) {
                result.add(String.valueOf(char1));
            }
            return result;
        }

        int use1 = Math.min(2, max1);
        int use2 = (max1 - use1 >= max2) ? 1 : 0;
        List<String> result = new ArrayList<>();
        for (int index = 0; index < use1; index++) {
            result.add(String.valueOf(char1));
        }
        for (int index = 0; index < use2; index++) {
            result.add(String.valueOf(char2));
        }
        result.addAll(recursion(max1 - use1, max2 - use2, max3, char1, char2, char3));
        return result;
    }
}