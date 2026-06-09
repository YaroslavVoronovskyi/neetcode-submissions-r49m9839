class MedianFinder {

    private List<Integer> data;

    public MedianFinder() {
        data = new ArrayList<>();
    }
    
    public void addNum(int num) {
        data.add(num);
    }
    
    public double findMedian() {
        Collections.sort(data);
        int size = data.size();
        if ((size & 1) == 1) {
            return data.get(size / 2);
        } else {
            return (data.get(size / 2) + data.get(size / 2 - 1)) / 2.0;
        }
    }
}
