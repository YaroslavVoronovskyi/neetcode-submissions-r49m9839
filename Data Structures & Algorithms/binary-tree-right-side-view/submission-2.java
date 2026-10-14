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

    private List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        depthFirstSearch(root, 0);
        return result;
    }

    private void depthFirstSearch(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(root.val);
        }
        depthFirstSearch(root.right, depth + 1);
        depthFirstSearch(root.left, depth + 1);
    }
}
