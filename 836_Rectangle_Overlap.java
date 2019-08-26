class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] > rec2[0]) {
            return isRectangleOverlap(rec2, rec1);
        }
        
        if (rec1[2] <= rec2[0]) {
            return false;
        }
        
        if (rec1[3] <= rec2[1] || rec1[1] >= rec2[3]) {
            return false;
        }
        
        return true;
    }
}