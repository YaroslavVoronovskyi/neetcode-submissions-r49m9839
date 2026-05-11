class Solution {
    public int maxProduct(int[] numbers) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> current = new ArrayList<>(); 
        int result = Integer.MIN_VALUE;

        for (int number : numbers) {
            result = Math.max(result, number);
            if (number == 0) {
                if (!current.isEmpty()) {
                    list.add(current);
                }
                current = new ArrayList<>();
            } else {
                current.add(number);
            }
        }
        if (!current.isEmpty()) {
            list.add(current);
        }

        for (List<Integer> subList : list) {
            int negs = 0;
            for (int item : subList) {
                if (item < 0) {
                    negs++;
                }
            }

            int prod = 1;
            int need = (negs % 2 == 0) ? negs : (negs - 1);
            negs = 0;
            for (int i = 0, j = 0; i < subList.size(); i++) {
                prod *= subList.get(i);
                if (subList.get(i) < 0) {
                    negs++;
                    while (negs > need) {
                        prod /= subList.get(j);
                        if (subList.get(j) < 0) {
                            negs--;
                        }
                        j++;
                    }
                }
                if (j <= i) {
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }
}
