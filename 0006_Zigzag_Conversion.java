class Solution {
    public String convert(String s, int numRows) {
        if (s == null) {
            return null;
        }
        
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++, i++) {
                sbs[j].append(s.charAt(i));
            }
            for (int j = numRows - 2; j >= 1 && i < s.length(); j--, i++) {
                sbs[j].append(s.charAt(i));
            }
        }
        
        for (int k = 1; k < sbs.length; k++) {
            sbs[0].append(sbs[k]);
        }
        return sbs[0].toString();
    }
}