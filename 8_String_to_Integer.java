class Solution {
    public int myAtoi(String str) {
       str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        
        boolean isPositive = true;
        int low = 0;
        char first = str.charAt(low);
        if (first == '-') {
            isPositive = false;
            low++;
        } else if (first == '+') {
            isPositive =true;
            low++;
        } else if (!Character.isDigit(first)) {
            return 0;
        }
        
        int high = low;
        while (high < str.length() && Character.isDigit(str.charAt(high))) {
            high++;
        }
        
        if (low == high) {
            return 0;
        }
        
        str = str.substring(low, high);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = (int)(str.charAt(i) - '0');
            
            if (isPositive) {
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > 7)) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (-result < Integer.MIN_VALUE / 10 || (-result == Integer.MIN_VALUE / 10 && num > 8)) {
                    return Integer.MIN_VALUE;
                }
            }
            result = 10 * result + (int)(str.charAt(i) - '0');
        }
        
        return isPositive ? result : -result;
    }
    
}