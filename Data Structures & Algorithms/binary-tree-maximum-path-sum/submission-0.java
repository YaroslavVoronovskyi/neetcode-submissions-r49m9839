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

    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        depthFirstSearch(root);
        return result;
    }

    private void depthFirstSearch(TreeNode root) {
        if (root == null) {
            return;
        }
        int left = getMax(root.left);
        int right = getMax(root.right);
        result = Math.max(result, root.val + left + right);
        depthFirstSearch(root.left);
        depthFirstSearch(root.right);
    }

    private int getMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMax(root.left);
        int right = getMax(root.right);
        int path = root.val + Math.max(left, right);
        return Math.max(0, path);
    }
}
