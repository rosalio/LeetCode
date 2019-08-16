class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0){ // Return infinity when divisor is 0
            return Integer.MAX_VALUE;
        }
        
        if (dividend == 0) { // Return 0 when dividend is 0
            return 0;
        }
        
        if (divisor == 1) { // Return dividend directly when divisor is 1
            return dividend;
        }
        
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend; // Out of range
        }
        
        // Get the sign and do bit division on abstract values
        final boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long longDividend = Math.abs((long) dividend);
        final long longDivisor = Math.abs((long) divisor);
        int res = 0;
        for (int bit = Integer.SIZE - 1; bit >=0 && longDividend >= longDivisor; bit--) {
            if (longDividend >= (longDivisor << bit)) {
                res |= (1 << bit);
                longDividend -= (longDivisor << bit);
            }
        }
        return isNegative ? -res : res;
    }
}