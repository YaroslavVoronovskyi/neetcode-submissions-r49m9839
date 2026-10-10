class Solution {
    public int countSeniors(String[] details) {
        int size = details.length;
        List<String> ages = new ArrayList<>();
        for (String detail : details) {
            char age1 = detail.charAt(detail.length() - 4);
            char age2 =detail.charAt(detail.length() - 3);
            String age = String.valueOf(age1) + String.valueOf(age2);
            if (Integer.parseInt(age) > 60) {
                ages.add(age);
            }
        }
        return ages.size();
    }
}