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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        
        while (p != null || q != null || !stackP.isEmpty()) {
            while (p != null || q != null) {
                if (p == null || q == null) return false;
                if (p.val != q.val) return false;
                stackP.push(p);
                stackQ.push(q);
                p = p.left;
                q = q.left;
            }
            p = stackP.pop().right;
            q = stackQ.pop().right;
        }
        return true;
    }
}