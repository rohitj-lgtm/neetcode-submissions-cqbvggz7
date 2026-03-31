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
    private TreeNode buildTree(int[] preOrder, int[] inOrder, Map<Integer, Integer> inMap, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preOrder, inOrder, inMap, preStart + 1, preStart + numsLeft, inStart, inRoot - 1);
        root.right = buildTree(preOrder, inOrder, inMap, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd);

        return root;
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        
        Map<Integer, Integer> inMap = new HashMap<>();
        int length = inOrder.length;

        for (int i = 0; i < length; i++) {
            inMap.put(inOrder[i], i);
        }

        return buildTree(preOrder, inOrder, inMap, 0, length - 1, 0, length - 1);
    }
}
