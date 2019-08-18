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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        List<TreeNode> prevLevel = Arrays.asList(root);
        while (!prevLevel.isEmpty()) {
            List<TreeNode> currLevel = new ArrayList<>();
            for (int i = 0; i < prevLevel.size(); i++) {
                TreeNode node = prevLevel.get(i);
                if (i == prevLevel.size() - 1) {
                    ans.add(node.val);
                }
                
                if (node.left != null) {
                    currLevel.add(node.left);
                }
                if (node.right != null) {
                    currLevel.add(node.right);
                }
            }
            prevLevel = currLevel;
        }
        
        return ans;
    }
}