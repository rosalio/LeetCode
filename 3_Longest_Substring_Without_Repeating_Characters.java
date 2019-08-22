class Solution {

    // Use array for ASCII input
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        char[] ss = s.toCharArray();
        int[] tt = new int[256];
        Arrays.fill(tt, -1);
        int l = 0;
        int r = 0;
        int maxLen = 0;
        for (r = 0; r < ss.length; r++) {
            if (tt[ss[r]] == -1 || tt[ss[r]] < l) {
                maxLen = Math.max(maxLen, r - l + 1);
            } else {
                l = tt[ss[r]] + 1;
            }
            tt[ss[r]] = r;
        }

        return maxLen;
    }

    // Sliding window approach
    // public int lengthOfLongestSubstring(String s) {
    //     if (s == null) {
    //         return 0;
    //     }
        
    //     Set<Character> set = new HashSet<>();
    //     int left = 0;
    //     int right = 0;
    //     int maximum = 0;
    //     while (right < s.length()) {
    //         char ch = s.charAt(right);
    //         if (set.contains(ch)) {
    //             set.remove(s.charAt(left++));
    //         } else {
    //             set.add(ch);
    //             if (set.size() > maximum) {
    //                 maximum = set.size();
    //             }
    //             right++;
    //         }
    //     }
    //     return maximum;
    // }

    // Optimized sliding window approach
    // public int lengthOfLongestSubstring(String s) {
    //     if (s == null) {
    //         return 0;
    //     }
        
    //     Map<Character, Integer> map = new HashMap<>();
    //     int maximum = 0;
    //     int i = 0;
    //     for (int j = 0; j < s.length(); j++) {
    //         if (map.containsKey(s.charAt(j))) {
    //             i = Math.max(map.get(s.charAt(j)), i);
    //         }
    //         maximum = Math.max(maximum, j - i + 1);
    //         map.put(s.charAt(j), j + 1);
    //     }
    //     return maximum;
    // }
}