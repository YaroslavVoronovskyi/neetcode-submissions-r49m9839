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
        if (first == null && second == null) {
            return true;
        }
        if (first != null && second != null && first.val == second.val) {
            return isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
        } else {
            return false;
        }
        
    }
}
