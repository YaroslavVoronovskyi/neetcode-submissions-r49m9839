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
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{root.val};
        depthFirstSearch(root, result);
        return result[0];
    }

    private int depthFirstSearch(TreeNode root, int[] result) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(depthFirstSearch(root.left, result), 0);
        int rightMax = Math.max(depthFirstSearch(root.right, result), 0);
        result[0] = Math.max(result[0], root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
