class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int toAdd = x % 10;
            if (willOverflow(result, toAdd)) {
                return 0;
            }
            result = 10 * result + toAdd;
            x = x / 10;
        }
        return result;
    }
    
    private boolean willOverflow(int num, int toAdd) {
        if (num > Integer.MAX_VALUE / 10) {
            return true;
        }
        if (num == Integer.MAX_VALUE / 10 && toAdd > 7) {
            return true;
        }
        if (num < Integer.MIN_VALUE / 10) {
            return true;
        }
        if (num == Integer.MIN_VALUE / 10 && toAdd < -8) {
            return true;
        }
        return false;
    }

    // Use Long and convert to Integer
    // public int reverse(int x) {
    //     long result = 0;
    //     while (x != 0) {
    //         result = 10 * result +  x % 10;;
    //         if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
    //             return 0;
    //         }
    //         x = x / 10;
    //     }
    //     return (int) result;
    // }
}