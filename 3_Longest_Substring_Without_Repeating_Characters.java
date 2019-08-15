class Solution {

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
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int maximum = 0;
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maximum = Math.max(maximum, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return maximum;
    }
}