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
        List<Integer> array = new ArrayList<>();
        depthFirstSearch(root, array);
        Collections.sort(array);
        return array.get(key - 1);
    }

    private void depthFirstSearch(TreeNode node, List<Integer> array) {
        if (node == null) {
            return;
        }
        array.add(node.val);
        depthFirstSearch(node.left, array);
        depthFirstSearch(node.right, array);
    }


}
