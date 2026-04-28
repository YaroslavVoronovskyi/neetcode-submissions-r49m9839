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
    private Map<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int index = 0; index < inorder.length; index++) {
            indices.put(inorder[index], index);
        }
        return depthFirstSearch(preorder, 0, inorder.length - 1);
    }

    private TreeNode depthFirstSearch(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        int middle = indices.get(rootValue);
        root.left = depthFirstSearch(preorder, left, middle - 1);
        root.right = depthFirstSearch(preorder, middle + 1, right);
        return root;
    }
}
