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
        Queue<TreeNode> firstQueue = new LinkedList<>();
        Queue<TreeNode> secondQueue = new LinkedList<>();
        firstQueue.add(first);
        secondQueue.add(second);

        while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
            for (int index = firstQueue.size(); index > 0; index--) {
                TreeNode firstNode = firstQueue.poll();
                TreeNode secondNode = secondQueue.poll();

                if (firstNode == null && secondNode == null) {
                    continue;
                }
                if (firstNode == null || secondNode == null || firstNode.val != secondNode.val) {
                    return false;
                }
                firstQueue.add(firstNode.left);
                firstQueue.add(firstNode.right);
                secondQueue.add(secondNode.left);
                secondQueue.add(secondNode.right);
            }
        }
        return true;
    }
}
