class StockSpanner {

    private List<Integer> list;

    public StockSpanner() {
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);
        int index = list.size() - 2;
        while (index >= 0 && list.get(index) <= price) {
            index--;
        }
        return list.size() - index - 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */