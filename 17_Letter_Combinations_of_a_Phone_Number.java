class Solution {
    
    private Map<String, String> map;
    private List<String> result;
    
    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        
        map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        if (!digits.isEmpty()) {
           combinations(digits, "");
        }
        return result;
    }
    
    private void combinations(String digits, String tmp) {
        if (digits.length() == 1) {
            String str = map.get(digits);
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                result.add(tmp + ch);
            }
            return;
        }
        
        String str1 = digits.substring(0, 1);
        String str2 = digits.substring(1);
        
        String str = map.get(str1);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            combinations(str2, tmp + ch);
        }
    }
}