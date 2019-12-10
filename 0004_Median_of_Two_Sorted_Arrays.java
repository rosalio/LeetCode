class Solution {

    // Time complexity: O(log(m + n))
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        // Make sure len1 < len2
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int k = (len1 + len2 + 1) / 2;
        
        int l = 0, r = len1;
        while (l < r) {
            int m1 = l + (r - l) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]) {
                l = m1 + 1;
            } else {
                r = m1;
            }
        }
        
        int m1 = l;
        int m2 = k - l;
        
        int c1 = Math.max(m1 <= 0? Integer.MIN_VALUE : nums1[m1 - 1],
                          m2 <= 0? Integer.MIN_VALUE : nums2[m2 - 1]);
        
        if ((len1 + len2) % 2 == 1) {
            return c1;
        }
        
        int c2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE : nums1[m1],
                          m2 >= len2 ? Integer.MAX_VALUE : nums2[m2]);
        
        return (c1 + c2) * 0.5;
    }


    // Time complexity: O(m + n)
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int[] arr = new int[len];
        
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        
        while (i < m) {
            arr[k++] = nums1[i++];
        }
        
        while (j < n) {
            arr[k++] = nums2[j++];
        }
        
        if (arr.length % 2 == 0) {
            return 0.5 * (arr[len / 2] + arr[len / 2 - 1]);
        } else {
            return arr[len / 2];
        }
    }
}