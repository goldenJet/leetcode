/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    private int res = Integer.MAX_VALUE;
    private int preVal = -1; //前一节点的值
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return res;
    }
    private void inorder(TreeNode root) {
        // 二叉搜索树的中序遍历是升序的，中序遍历时两两相邻的值的差值最小就是结果
        if(root == null) return;
        inorder(root.left);
        if(preVal < 0)
            preVal = root.val; //所有节点值是非负的，中序遍历的第一个节点值赋值给preVal
        else {
            int tmp = root.val - preVal; //当前值与前一节点值做差
            res = Math.min(tmp, res);
            preVal = root.val; //更新preVal
        }
        inorder(root.right);
    }
}
// @lc code=end

