class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
     
        List<List<Integer>> ans = new ArrayList<>();
        
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            
            if (curr[0] > prev[1]) {
                ans.add(Arrays.asList(prev[0], prev[1])); 
                prev = curr;
            } else {
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        ans.add(Arrays.asList(prev[0], prev[1]));
        
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        
        return res;
    }
}