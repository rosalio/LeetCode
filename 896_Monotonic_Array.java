class Solution {
    public boolean isMonotonic(int[] A) {
        int len = A.length;
        if (len <= 2) {
            return true;
        }
        
        boolean isIncreasing = true;
        boolean isFlagSet = false;
        
        for (int i = 1; i < len; i++) {
            if (!isFlagSet) {
                if (A[i] > A[i - 1]) {
                    isIncreasing = true;
                    isFlagSet = true;
                } else if (A[i] < A[i - 1]) {
                    isIncreasing = false;
                    isFlagSet = true;
                }   
            } else {
                if (A[i] > A[i - 1] && !isIncreasing) {
                    return false;
                }
                if (A[i] < A[i - 1] && isIncreasing) {
                    return false;
                }
            }
        }
        
        return true;
    }
}