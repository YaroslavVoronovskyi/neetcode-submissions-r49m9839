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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        TreeNode parent = null;
        TreeNode current = root;
        while (current != null && current.val != key) {
            parent = current;
            if (key > current.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        if (current == null) {
            return root;
        }

        if (current.left == null || current.right == null) {
            TreeNode child = (current.left != null) ? current.left : current.right;
            if (parent == null) {
                return child;
            }
            if (parent.left == current) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            TreeNode par = null;
            TreeNode delNode = current;
            current = current.right;
            while (current.left != null) {
                par = current;
                current = current.left;
            }
            if (par != null) {
                par.left = current.right;
                current.right = delNode.right;
            }
            current.left = delNode.left;
            if (parent == null) {
                return current;
            }
            if (parent.left == delNode) {
                parent.left = current;
            } else {
                parent.right = current;
            }
        }
        return root;
    }
}