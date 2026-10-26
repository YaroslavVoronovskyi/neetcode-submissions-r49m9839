class KthLargest {

    private List<Integer> list;
    private int target;
    
    public KthLargest(int target, int[] numbers) {
        this.target = target;
        list = new ArrayList<>();
        for (int index = 0; index < numbers.length; index++) {
            list.add(numbers[index]);
        }
    }

    public int add(int value) {
       list.add(value);
       Collections.sort(list);
       return list.get(list.size() - target);
    }
}
