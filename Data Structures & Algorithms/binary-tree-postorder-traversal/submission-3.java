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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.right == null) {
                result.add(current.val);
                current = current.left;
            } else {
                TreeNode prev = current.right;
                while (prev.left != null && prev.left != current) {
                    prev = prev.left;
                }
                if (prev.left == null) {
                    result.add(current.val);
                    prev.left = current;
                    current = current.right;
                } else {
                    prev.left = null;
                    current = current.left;
                }
            }
        }
        Collections.reverse(result);
        return result;
    }
}