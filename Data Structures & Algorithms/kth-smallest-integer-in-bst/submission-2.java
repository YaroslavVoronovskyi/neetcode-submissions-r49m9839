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
    public int kthSmallest(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();
        depthFirstSearch(root, list);
        return list.get(key - 1);
    }

    private void depthFirstSearch(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        depthFirstSearch(root.left, list);
        list.add(root.val);
        depthFirstSearch(root.right, list);
    }
}
