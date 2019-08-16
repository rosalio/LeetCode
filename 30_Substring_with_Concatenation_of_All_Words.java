class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words.length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> result = new ArrayList<>();
        int numOfWords = words.length;
        int wordLength = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - numOfWords * wordLength; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            int numOfWordsRemains = numOfWords;
            int j = i;
            while (numOfWordsRemains > 0) {
                String str = s.substring(j, j + wordLength);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    break;
                }
                copy.put(str, copy.get(str) - 1);
                numOfWordsRemains--;
                j += wordLength;
            }
            if (numOfWordsRemains == 0) {
                result.add(i);
            }
        }
        
        return result;
    }
}