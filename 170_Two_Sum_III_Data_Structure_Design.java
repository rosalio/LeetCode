class TwoSum {

    private List<Integer> list;
    
    
    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Collections.sort(list);

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == value) {
                return true;
            } else if (sum < value) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */