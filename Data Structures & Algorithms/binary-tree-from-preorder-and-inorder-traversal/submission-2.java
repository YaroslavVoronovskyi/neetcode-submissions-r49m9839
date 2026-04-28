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

    private int preorderIndex = 0;
    private int inorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return depthFirstSearch(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode depthFirstSearch(int[] preorder, int[] inorder, int limit) {
        if (inorderIndex >= preorder.length) {
            return null;
        }
        if (inorder[inorderIndex] == limit) {
            inorderIndex++;
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        root.left = depthFirstSearch(preorder, inorder, root.val);
        root.right = depthFirstSearch(preorder, inorder, limit);
        return root;
    }
}
