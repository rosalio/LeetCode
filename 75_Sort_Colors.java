class Solution {

    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }
    
    void sort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(nums, l, mid);
            sort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }
    
    void merge(int[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            L[i] = nums[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = nums[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }
        while (i < n1) {
            nums[k++] = L[i++];
        }
        while (j < n2) {
            nums[k++] = R[j++];
        }
    }


    // public void sortColors(int[] nums) {
    //     int[] counts = new int[3];
        
    //     for (int i = 0; i < nums.length; i++) {
    //         counts[nums[i]]++;
    //     }
        
    //     for (int i = 0; i < nums.length; i++) {
    //         int m = 0;
    //         if (i < counts[0]) {
    //             m = 0;
    //         } else if (i < counts[0] + counts[1]) {
    //             m = 1;
    //         } else {
    //             m = 2;
    //         }
            
    //         nums[i] = m;
    //     }
    // }
    
}