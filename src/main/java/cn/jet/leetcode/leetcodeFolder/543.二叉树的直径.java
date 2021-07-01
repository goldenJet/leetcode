/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 */

// @lc code=start
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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        calculationDeep(root);
        return max;
    }
    public int calculationDeep(TreeNode node) {
        if (node.left == null && node.right == null) return 0;
        int left = node.left == null ? 0 : calculationDeep(node.left) + 1;
        int right = node.right == null ? 0 : calculationDeep(node.right) + 1;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }
}
// @lc code=end

