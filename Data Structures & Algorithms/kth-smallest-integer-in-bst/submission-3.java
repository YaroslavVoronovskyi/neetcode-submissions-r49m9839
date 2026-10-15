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
        inOrderTrversal(root, list);
        return list.get(key - 1);
    }

    private void inOrderTrversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTrversal(root.left, list);
        list.add(root.val);
        inOrderTrversal(root.right, list);
    }
}
