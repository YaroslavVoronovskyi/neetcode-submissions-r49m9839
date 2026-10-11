class TimeMap {

    private Map<String, TreeMap<Integer, String>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!store.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> timestamps = store.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
