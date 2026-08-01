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

    private Map<TreeNode, Integer> cache;

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        cache = new HashMap<>();
        cache.put(null, 0);
        return depthFirstSearch(root);
    }

    private int depthFirstSearch(TreeNode root) {
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int result = root.val;
        if (root.left != null) {
            result += depthFirstSearch(root.left.left) + depthFirstSearch(root.left.right);
        }
        if (root.right != null) {
            result += depthFirstSearch(root.right.left) + depthFirstSearch(root.right.right);
        }
        result = Math.max(result, depthFirstSearch(root.left) + depthFirstSearch(root.right));
        cache.put(root, result);
        return result;
    }
}