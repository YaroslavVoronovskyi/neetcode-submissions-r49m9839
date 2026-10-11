class TimeMap {

    private Map<String, Map<Integer, List<String>>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!store.containsKey(key)) {
            store.put(key, new HashMap<>());
        }
        if (!store.get(key).containsKey(timestamp)) {
            store.get(key).put(timestamp, new ArrayList<>());
        }
        store.get(key).get(timestamp).add(value);
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }
        int seen = -1;
        for (int time : store.get(key).keySet()) {
            if (time <= timestamp) {
                seen = Math.max(seen, time);
            }
        }
        if (seen == -1) {
            return "";
        }
        int back = store.get(key).get(seen).size() - 1;
        return store.get(key).get(seen).get(back);
    }
}
