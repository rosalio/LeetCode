class Solution {
    public int myAtoi(String str) {
        if (str == null) { return 0; }
        str = str.trim();
        if (str.isEmpty()) {return 0; }
        
        int i = 0;
        boolean isNegative = false;
        char first = str.charAt(0);
        if (first == '+') {
            i++;
        } else if ( first == '-') {
            isNegative = true;
            i++;
        } else if (!Character.isDigit(first)) {
            return 0;
        }
        
        int j = i;
        while (j < str.length() && Character.isDigit(str.charAt(j))) {
            j++;
        }
        String digit = str.substring(i, j);
        
        int num = 0;
        for (int k = 0; k < digit.length(); k++) {
            if (isNegative) {
                if (-num < Integer.MIN_VALUE / 10) {
                    return Integer.MIN_VALUE;
                }
                if (-num == Integer.MIN_VALUE / 10 && digit.charAt(k) > '8') {
                    return Integer.MIN_VALUE;
                }
            } else {
                if (num > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                }
                if (num == Integer.MAX_VALUE / 10 && digit.charAt(k) > '7') {
                    return Integer.MAX_VALUE;
                }
            }
            
            num = 10 * num + digit.charAt(k) - '0';
        }
        
        return isNegative ? -num : num;
    }
}