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
    public boolean isSameTree(TreeNode first, TreeNode second) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{first, second});

        while (!stack.isEmpty()) {
            TreeNode[] nodes = stack.pop();
            TreeNode firstNode = nodes[0];
            TreeNode secondNode = nodes[1];
            if (firstNode == null && secondNode == null) {
                continue;
            }
            if (firstNode == null || secondNode == null || firstNode.val != secondNode.val) {
                return false;
            }
            stack.push(new TreeNode[]{firstNode.right, secondNode.right});
            stack.push(new TreeNode[]{firstNode.left, secondNode.left});
        }
        return true;
    }
}
