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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode rightSide = null;
            int qLen = queue.size();

            for (int index = 0; index < qLen; index++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    rightSide = node;
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (rightSide != null) {
                result.add(rightSide.val);
            }
        }
        return result;
    }
}
