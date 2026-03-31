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
    private Node trueLeaf;
    private Node falseLeaf;
    
    private Node getTrueLeaf() {
        if (trueLeaf == null) {
            trueLeaf = new Node(true, true);
        }
        return trueLeaf;
    }
    
    private Node getFalseLeaf() {
        if (falseLeaf == null) {
            falseLeaf = new Node(false, true);
        }
        return falseLeaf;
    }

    private Node dfs(int[][] grid, int n, int r, int c) {
        if(n == 1) {
            return grid[r][c] == 1 ? getTrueLeaf() : getFalseLeaf();
        }

        int mid = n / 2;
        Node topLeft = dfs(grid, mid, r, c);
        Node topRight = dfs(grid, mid, r, c + mid);
        Node bottomLeft = dfs(grid, mid, r + mid, c);
        Node bottomRight = dfs(grid, mid, r + mid, c + mid);

        boolean val  = topLeft.val;
        boolean isLeaf = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topRight.val == val
        && bottomLeft.val == val && bottomRight.val == val;


        if(isLeaf){
            return topLeft;
        } else {
            
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
    public Node construct(int[][] grid) {
        return dfs(grid, grid.length, 0, 0);
    }
}