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

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        depthFirstSearch(root, 0);
        return result;
    }

    private void depthFirstSearch(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(node.val);
        depthFirstSearch(node.left, depth + 1);
        depthFirstSearch(node.right, depth + 1);
    }
}
