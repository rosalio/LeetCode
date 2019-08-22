class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        char[] oo = order.toCharArray();
        for (int i = 0; i < oo.length; ++i) {
            map.put(oo[i], i);
        }
        
        int len = words.length;
        if (len < 2) {
            return true;
        }
        
        for (int i = 1; i < len; ++i) {
            String first = words[i - 1];
            String second = words[i];
            if (!isOrdered(first, second, map)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isOrdered(String s1, String s2, Map<Character, Integer> map) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        int len = Math.min(len1, len2);
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        for (int i = 0; i < len; i++) {
            if (ss1[i] == ss2[i]) {
                continue;
            }
            if (map.get(ss1[i]) > map.get(ss2[i])) {
                return false;
            }
            return true;
        }
        if (len1 > len) {
            return false;
        }
        return true;
    }
}