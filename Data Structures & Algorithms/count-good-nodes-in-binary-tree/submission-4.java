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

    private int depthFirstSearch(TreeNode root, int key) {
        if (root == null) {
            return 0;
        }
        int result = (root.val >= key) ? 1 : 0;
        key = Math.max(key, root.val);
        result += depthFirstSearch(root.left, key);
        result += depthFirstSearch(root.right, key);
        return result;
    }
}
