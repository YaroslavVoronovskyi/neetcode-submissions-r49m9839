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
        inOrder(root, list);
        Collections.sort(list);
        return list.get(key - 1);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        inOrder(root.left, list);
        inOrder(root.right, list);
    }
}
