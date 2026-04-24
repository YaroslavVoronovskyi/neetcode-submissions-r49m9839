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
    public int goodNodes(TreeNode root) {
        return depthFirstSearch(root, root.val);
    }

    private int depthFirstSearch(TreeNode node, int maxValue) {
        if (node == null) {
            return 0;
        }
        int result = (node.val >= maxValue) ? 1 : 0;
        maxValue = Math.max(maxValue, node.val);
        result += depthFirstSearch(node.left, maxValue);
        result += depthFirstSearch(node.right, maxValue);
        return result;
    }
}
