/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeNode(root, sb);
        return sb.toString();
    }

    private void serializeNode(TreeNode root, StringBuilder sb) {
        write(root, sb);
        if (root == null) {
            return;
        }
        serializeNode(root.left, sb);
        serializeNode(root.right, sb);
    }

    private void write(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
        } else {
            sb.append(root.val + " ");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] dataArr = data.split("\\s+");
        Queue<String> queue = new LinkedList<>();
        for (String s : dataArr) {
            queue.add(s);
        }
        return deserializeData(queue);
    }

    private TreeNode deserializeData(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        TreeNode root = read(queue.poll());

        if (root == null) {
            return null;
        }
        root.left = deserializeData(queue);
        root.right = deserializeData(queue);
        return root;
    }

    private TreeNode read(String str) {
        if (str.equals("#")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(str));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));