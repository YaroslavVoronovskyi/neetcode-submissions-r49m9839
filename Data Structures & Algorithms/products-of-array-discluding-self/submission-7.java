class Solution {
    public int[] productExceptSelf(int[] numbers) {
        int size = numbers.length;
        int[] result = new int[size];
        int[] pref = new int[size];
        int[] suff = new int[size];

        pref[0] = 1;
        suff[size - 1] = 1;
        for (int i = 1; i < size; i++) {
            pref[i] = numbers[i - 1] * pref[i - 1];
        }
        for (int i = size - 2; i >= 0; i--) {
            suff[i] = numbers[i + 1] * suff[i + 1];
        }
        for (int i = 0; i < size; i++) {
            result[i] = pref[i] * suff[i];
        }
        return result;
    }
}  
