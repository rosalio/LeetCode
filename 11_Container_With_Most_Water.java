class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int lHeight = height[l];
            int rHeight = height[r];
            int area = Math.min(lHeight, rHeight) * (r - l);
            if (area >  maxArea) {
                maxArea = area;
            }
            if (lHeight < rHeight) {
                l++;
            } else {
                r--;
            }
         }
        return maxArea;
    }
}