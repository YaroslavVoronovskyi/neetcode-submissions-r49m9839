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
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int middle = -1;
        for (int index = 0; index < inorder.length; index++) {
            if (inorder[index]== preorder[0]) {
                middle = index;
                break;
            }
        }
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, middle + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, middle);
        root.left = buildTree(leftPreorder, leftInorder);
        
        int[] rightPreorder = Arrays.copyOfRange(preorder, middle + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, middle + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);
        
        return root;
    }
}
