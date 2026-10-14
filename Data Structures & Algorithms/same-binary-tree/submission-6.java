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
    public boolean isSameTree(TreeNode first, TreeNode second) {
        if (first == null && second == null) {
            return true;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(first);
        queue2.add(second);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            for (int index = queue1.size(); index > 0; index--) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null || node1.val != node2.val) {
                    return false;
                }
                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.left);
                queue2.add(node2.right);
            }
        }
        return true;
    }
}
