class Solution {
    // Reverse half integer
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reverted = 0;
        while (x > reverted) {
            reverted = 10 * reverted + x % 10;
            x /= 10;
        }
      
        return x == reverted || x == reverted / 10;
    }
}