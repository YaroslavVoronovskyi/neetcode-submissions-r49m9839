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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String serializedRoot = serialize(root);
        String serializedSubRoot = serialize(subRoot);
        String combined = serializedSubRoot + "|" + serializedRoot;

        int[] values = function(combined);
        int subRootSize = serializedSubRoot.length();

        for (int index = subRootSize + 1; index < combined.length(); index++) {
            if (values[index] == subRootSize) {
                return true;
            }
        }
        return false;
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "$#";
        }
        return "$" + root.val + serialize(root.left) + serialize(root.right);
    }

    public int[] function(String expression) {
        int size = expression.length();
        int[] result = new int[size];
        int left = 0;
        int right = 0;
        for (int index = 1; index < size; index++) {
            if (index <= right) {
                result[index] = Math.min(right - index + 1, result[index - left]);
            }
            while (index + result[index] < size && expression.charAt(result[index]) == expression.charAt(index + result[index])) {
                result[index]++;
            }
            if (index + result[index] - 1 > right) {
                left = index;
                right = index + result[index] - 1;
            }
        }
        return result;
    }
}
