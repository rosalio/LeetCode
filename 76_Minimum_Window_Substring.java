class Solution {
    public String minWindow(String s, String t) {        
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        if (tt.length == 0) {
            return "";
        }
        
        int[] cntS = new int[256];
        int[] cntT = new int[256];
        for (int i = 0; i < 256; i++) {
            cntS[i] = 0;
            cntT[i] = 0;
        }
        
        int targetCount = 0;
        for (char c : tt) {
            cntT[c]++;
            if (cntT[c] == 1) {
                targetCount++;
            }
        }

        int count = 0;
        int ansL = -1;
        int ansR = -1;
        int left = 0;
        int right = 0;
        
        for (left = 0; left < ss.length; left++) {
            while (right < ss.length && count < targetCount) {
                cntS[ss[right]]++;
                if (cntS[ss[right]] == cntT[ss[right]]) {
                    count++;
                }
                right++;
            }
            
            if (count == targetCount) {
                if (ansL == -1 || right - left < ansR - ansL) {
                    ansL = left;
                    ansR = right;
                }
            }
            
            cntS[ss[left]]--;
            if (cntS[ss[left]] == cntT[ss[left]] - 1) {
                count--;
            }
        }
        
        if (ansL == -1) {
            return "";
        }
        
        return s.substring(ansL, ansR);
    }
}