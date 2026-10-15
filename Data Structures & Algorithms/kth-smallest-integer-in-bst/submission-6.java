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
    public int kthSmallest(TreeNode root, int key) {
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                key--;
                if (key == 0) {
                    return current.val;
                }
                current = current.right;
            } else {
                TreeNode pred = current.left;
                while (pred.right != null && pred.right != current) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = current;
                    current = current.left;
                } else {
                    pred.right = null;
                    key--;
                    if (key == 0) {
                        return current.val;
                    }
                    current = current.right;
                 }
            }
        }
        return -1;
    }
}
