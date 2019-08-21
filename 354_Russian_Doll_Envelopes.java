class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                }
                return e1[1] - e2[1];
            }
        });

        int[] f = new int[n];
        
        int max = 0;
        for (int j = 0; j < n; j++) {
            f[j] = 1;
            for (int i = 0; i < j; i++) {
                if (envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]) {
                    f[j] = Math.max(f[j], f[i] + 1);
                }
            }
            max = Math.max(f[j], max);
        }
        return max; 
    }
}