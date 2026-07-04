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
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visit = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        visit.push(false);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            boolean v = visit.pop();
            if (current != null) {
                if (v) {
                    result.add(current.val);
                } else {
                    stack.push(current);
                    visit.push(true);
                    stack.push(current.right);
                    visit.push(false);
                    stack.push(current.left);
                    visit.push(false);
                }
            }
        }
        return result;
    }
}