import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (47.98%)
 * Likes:    421
 * Dislikes: 0
 * Total Accepted:    49.8K
 * Total Submissions: 103.5K
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠/ \ / \
 * 3  4 4  3
 * 
 * 
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   2
 * ⁠  \   \
 * ⁠  3    3
 * 
 * 
 * 说明:
 * 
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right != null) return false;
        if (root.right == null && root.left != null) return false;
        if (root.left == null) return true;
        return isSymmetricCommon(root.left, root.right);
    }

    public boolean isSymmetricCommon(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 != null) return false;
        if (node2 == null && node1 != null) return false;
        if (node1 == null) return true;
        if (node1.val != node2.val) return false;
        return isSymmetricCommon(node1.left, node2.right) && isSymmetricCommon(node2.left, node1.right);
    }
}

