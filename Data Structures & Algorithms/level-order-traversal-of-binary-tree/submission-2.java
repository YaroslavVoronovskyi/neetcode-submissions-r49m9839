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

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        depthFirstSearch(root, 0);
        return result;
    }

    private void depthFirstSearch(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        depthFirstSearch(root.left, depth + 1);
        depthFirstSearch(root.right, depth +1);
    } 
}
