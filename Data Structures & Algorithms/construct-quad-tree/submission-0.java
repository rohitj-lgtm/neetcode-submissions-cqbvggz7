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
    private Node dfs(int[][] grid, int n, int r, int c) {
        boolean isSame = true;
        int val = grid[r][c];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(val != grid[i + r][j + c]){
                    isSame = false;
                    break;
                }
            }
            if(!isSame) break;
        }
        if(isSame){
            return new Node(val == 1, true);
        } else {
            int newN = n / 2;
            Node topLeft = dfs(grid, newN, r, c);
            Node topRight = dfs(grid, newN, r, c + newN);
            Node bottomLeft = dfs(grid, newN, r + newN, c);
            Node bottomRight = dfs(grid, newN, r + newN, c + newN);
            return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
    public Node construct(int[][] grid) {
        return dfs(grid, grid.length, 0, 0);
    }
}