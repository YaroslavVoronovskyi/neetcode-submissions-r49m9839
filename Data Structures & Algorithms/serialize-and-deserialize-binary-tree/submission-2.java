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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        depthFirstSearchSerialize(root, result);
        return String.join(",", result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] indexes = {0};
        return depthFirstSearchDeserialize(values, indexes);
    }

    private void depthFirstSearchSerialize(TreeNode root, List<String> result) {
        if (root == null) {
            result.add("N");
            return;
        }
        result.add(String.valueOf(root.val));
        depthFirstSearchSerialize(root.left, result);
        depthFirstSearchSerialize(root.right, result);
    }

    private TreeNode depthFirstSearchDeserialize(String[] values, int[] indexes) {
        if (values[indexes[0]].equals("N")) {
            indexes[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[indexes[0]]));
        indexes[0]++;
        node.left = depthFirstSearchDeserialize(values, indexes);
        node.right = depthFirstSearchDeserialize(values, indexes);
        return node;
    }
}
