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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode head = new TreeNode(0);
        TreeNode current = head;
        int i = 0;
        int j = 0;
        int size = preorder.length;

        while (i < size && j < size) {
            current.right = new TreeNode(preorder[i], null, current.right);
            current = current.right;
            i++;
            while (i < size && current.val != inorder[j]) {
                current.left = new TreeNode(preorder[i], null, current);
                current = current.left;
                i++;
            }
            j++;
            while (current.right != null && j < size && current.right.val == inorder[j]) {
                TreeNode previous = current.right;
                current.right = null;
                current = previous;
                j++; 
            }
        }
        return head.right;
    }
}
