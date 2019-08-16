class Solution {
    public String intToRoman(int num) {
        final int[] numbers = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0 && i < numbers.length) {
            if (num >= numbers[i]) {
                sb.append(romans[i]);
                num -= numbers[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}