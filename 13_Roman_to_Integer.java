class Solution {
    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        
        char[] ss = s.toCharArray();
        int num = 0;
        for (int i = ss.length - 1; i >= 0; i--) {
            switch(ss[i]) {
                case 'I':
                    num += (num >=5) ? -1 : 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    num += (num >= 50) ? -10 : 10;
                    break; 
                case 'L':
                    num += 50;
                    break;    
                case 'C':
                    num += (num >= 500) ? -100 : 100;
                    break;   
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input!");
            }
        }
        return num;
    }
}