class Solution {

    // Use array for ASCII input
    public int lengthOfLongestSubstring1(String s) {
        if (s == null) {
            return 0;
        }
        
        char[] ss = s.toCharArray();
        int[] record = new int[256];
        Arrays.fill(record, -1);
        int l = 0, r = 0, res = 0;
        
        for (r = 0; r < ss.length; r++) {
            int rIdx = record[ss[r]];
            if (rIdx == -1 || rIdx < l) {
                res = Math.max(res, r - l + 1);
            } else {
                l = rIdx + 1;
            }
            record[ss[r]] = r;
        }
        
        return res;
    }

    // Sliding window approach
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }
        
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, res = 0;
        
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (set.contains(ch)) {
                set.remove(s.charAt(l++));
            } else {
                set.add(ch);
                res = Math.max(res, set.size());
                r++;
            }
        }
        
        return res;
    }

    // Optimized sliding window approach
    public int lengthOfLongestSubstring3(String s) {
        if (s == null) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, res = 0;
        
        for (r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                l = Math.max(map.get(ch) + 1, l);
            }
            res = Math.max(res, r - l + 1);
            map.put(ch, r);
        }
        
        return res;
    }
}