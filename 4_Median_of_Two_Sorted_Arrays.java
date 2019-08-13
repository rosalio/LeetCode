class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int len1 = nums1.length;
        final int len2 = nums2.length;

        // Make sure len1 < len2
        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        final int k = (len1 + len2 + 1) / 2;

        int l = 0;
        int r = len1;

        while (l < r) {
            final int m1 = l + (r - l) / 2;
            final int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]) {
                l = m1 + 1;
            } else {
                r = m1;
            }
        }

        final int m1 = l;
        final int m2 = k - l;

        final int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
    
        if ((len1 + len2) % 2 == 1) {
            return c1;
        }

        final int c2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE : nums1[m1],
                                m2 >= len2 ? Integer.MAX_VALUE : nums2[m2]);

        return (c1 + c2) * 0.5;
    }


    // Time complexity: O(n)
    // public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    //     int len1 = nums1.length;
    //     int len2 = nums2.length;
    //     int len = len1 + len2;
    //     int[] result = new int[len];
        
    //     int idx1 = 0;
    //     int idx2 = 0;
    //     int idx = 0;
    //     while (idx1 < len1 && idx2 < len2) {
    //         if (nums1[idx1] < nums2[idx2]) {
    //             result[idx++] = nums1[idx1++];
    //         } else {
    //             result[idx++] = nums2[idx2++];
    //         }
    //     }
    //     while (idx1 < len1) {
    //         result[idx++] = nums1[idx1++];
    //     }
    //     while (idx2 < len2) {
    //         result[idx++] = nums2[idx2++];
    //     }
        
    //     if (result.length % 2 == 0) {
    //         return 0.5 * (result[len / 2] + result[len / 2 - 1]);
    //     } else {
    //         return result[len / 2];
    //     }
    // }
}