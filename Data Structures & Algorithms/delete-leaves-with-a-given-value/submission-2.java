/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode visited = null;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            if (current.right != null && current.right != visited) {
                current = current.right;
                continue;
            }
            stack.pop();
            if (current.left == null && current.right == null && current.val == target) {
                if (stack.isEmpty()) {
                    return null;
                }
                TreeNode parent = stack.peek();
                if (parent.left == current) {
                    parent.left = null;
                } else if (parent.right == current) {
                    parent.right = null;
                }
            } else {
                visited = current;
            }
            current = null;
        }
        return root;
    }
}