class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        
        final Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        final char[] ss = s.toCharArray();
        final Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ss.length; ++i) {
            if (map.keySet().contains(ss[i])) {
                if (stack.isEmpty() || stack.peek() != map.get(ss[i])) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ss[i]);
            }
        }
        return stack.isEmpty();
    }
}