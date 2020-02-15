class Solution {
    
    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        
        int[] res = new int[3];
        res[0] = 0;
        res[1] = 1;

        int i = 2;
        while (i <= N) {
            res[i % 3] = res[(i - 2) % 3] + res[(i - 1) % 3];
            i++;
        }
        
        return res[(i - 1) % 3];
    }
}