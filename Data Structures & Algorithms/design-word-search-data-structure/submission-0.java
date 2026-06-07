class WordDictionary {

    private final List<String> store;

    public WordDictionary() {
        store = new ArrayList<>();
    }

    public void addWord(String word) {
        store.add(word);
    }

    public boolean search(String word) {
        for (String item : store) {
            if (item.length() != word.length()) {
                continue;
            }
            int index = 0;
            while (index < item.length()) {
                if (item.charAt(index) == word.charAt(index) || word.charAt(index) == '.') {
                    index++;
                } else {
                    break;
                }
            }
            if (index == item.length()) {
                return true;
            }
        }
        return false;
    }
}
