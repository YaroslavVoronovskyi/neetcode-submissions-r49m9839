/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    private final Node FALSE_LEAF = new Node(false, true);
    private final Node TRUE_LEAF = new Node(true, true);

    public Node construct(int[][] grid) {
        return depthFirstSearch(grid, grid.length, 0, 0);
    }

    private Node depthFirstSearch(int[][] grid, int size, int row, int col) {
        if (size == 1) {
            return grid[row][col] == 1 ? TRUE_LEAF : FALSE_LEAF;
        }
        int middle = size / 2;
        Node topLeft = depthFirstSearch(grid, middle, row, col);
        Node topRight = depthFirstSearch(grid, middle, row, col + middle);
        Node bottomLeft = depthFirstSearch(grid, middle, row + middle, col);
        Node bottomRight = depthFirstSearch(grid, middle, row + middle, col + middle);

        if (topLeft.isLeaf && topRight.isLeaf && 
            bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && 
            topLeft.val == bottomLeft.val && 
            topLeft.val == bottomRight.val) {
            return topLeft;
            }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}