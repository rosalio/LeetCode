/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int s = list.get(i) + list.get(j);
            if (s == k) {
                return true;
            }
            if (s < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}