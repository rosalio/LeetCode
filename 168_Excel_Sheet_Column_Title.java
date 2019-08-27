class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            char right = (char)((n - 1) % 26 + 'A');
            sb.insert(0, right);
            n = (n - 1) / 26;
        }
        return sb.toString();
    }
}