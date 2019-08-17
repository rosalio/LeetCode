class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String key = lexicographicalOrder(str);
            if (map.containsKey(key)) {
                List<Integer> value = map.get(key);
                value.add(i);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(i);
                map.put(key, value);
            }  
        }
        
        for (List<Integer> integers : map.values()) {
            List<String> level = new ArrayList<>();
            for (int num : integers) {
                level.add(strs[num]);
            }
            result.add(level);            
        }
        return result;
    }
    
    private String lexicographicalOrder(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}