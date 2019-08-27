public class Solution {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            String res = createRange(lower, true, upper, true);
            if (res == null) {
                return Collections.emptyList();
            }
            return Arrays.asList(res);
        }
        
        List<String> res = new ArrayList<>();
        if (nums.length > 1) {
            for (int i = 0; i < nums.length - 1; i++) {
                String str = createRange(nums[i], false, nums[i + 1], false);
                if (str != null) {
                    res.add(str);
                }
            }
        }
        
        String head = createRange(lower, true, nums[0], false);
        if (head != null) {
            res.add(0, head);
        }
        String tail = createRange(nums[nums.length - 1], false, upper, true);
        if (tail != null) {
            res.add(tail);
        }
        
        return res;
    }
    
    private String createRange(int left, boolean leftInclusive, int right, boolean rightInclusive) {
        if (left == right) {
            if (leftInclusive && rightInclusive) {
                return left + "";
            }
            return null;
        }

        if (left + 1 == right) {
            if (leftInclusive && rightInclusive) {
                return String.format("%d->%d", left, right);
            }
            if (leftInclusive) {
                return left + "";
            }
            if (rightInclusive) {
                return right + "";
            }
            return null;
        }
                
        if (left + 2 == right) {
            if (leftInclusive && rightInclusive) {
                return String.format("%d->%d", left, right);
            }
            if (leftInclusive) {
                return String.format("%d->%d", left, left + 1);
            }
            if (rightInclusive) {
                return String.format("%d->%d", right - 1, right);
            }
            return String.format("%d", left + 1);
        }
        
        if (leftInclusive && rightInclusive) {
            return String.format("%d->%d", left, right);
        }
        if (leftInclusive) {
            return String.format("%d->%d", left, right - 1);
        }
        if (rightInclusive) {
            return String.format("%d->%d", left + 1, right);
        }
        return String.format("%d->%d", left + 1, right - 1);
    }
    
}