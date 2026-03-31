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
    private boolean isSameTree(TreeNode p, TreeNode q) {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(isSameTree(node, subRoot)) return true;
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return false;
    }
}
