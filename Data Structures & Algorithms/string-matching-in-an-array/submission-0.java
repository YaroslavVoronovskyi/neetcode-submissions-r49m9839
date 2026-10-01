class Solution {
    public List<String> stringMatching(String[] words) {
        if (words.length == 0) {
            return List.of(); 
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }            
        }
        return result;
    }
}