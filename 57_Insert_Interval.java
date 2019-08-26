class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(Arrays.asList(intervals[i][0], intervals[i][1]));
        }
        intervalList.add(Arrays.asList(newInterval[0], newInterval[1]));
        
        intervalList.sort(Comparator.comparing(i -> i.get(0)));
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> prev = null;
        for (List<Integer> item : intervalList) {
            if (prev == null || prev.get(1) < item.get(0)) {
                ans.add(item);
                prev = item;
            } else {
                prev.set(1, Math.max(prev.get(1), item.get(1)));
            }
        }
        
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = new int[]{ans.get(i).get(0), ans.get(i).get(1)};
        }
        return res;
    }
}