/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return badVersion(1, n);
    }

    private int badVersion(int start, int end) {
        if (start == end) {
            return start;
        }

        int mid = start + (end - start) / 2;
        boolean res_mid = isBadVersion(mid);
        if (res_mid) {
            return badVersion(start, mid);
        } else {
            return badVersion(mid + 1, end);
        }
    }
}
