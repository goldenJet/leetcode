import java.util.ArrayList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (62.13%)
 * Likes:    129
 * Dislikes: 0
 * Total Accepted:    22.9K
 * Total Submissions: 36.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> mapList = new ArrayList();
        if (root == null) return mapList;
        mapList.add(Arrays.asList(root.val));
        levelOrderBottomCommon(root, mapList, 1);
        Collections.reverse(mapList);
        mapList.remove(0);
        return mapList;
    }

    public void levelOrderBottomCommon(TreeNode node, List<List<Integer>> mapList, int index) {
        if (node == null) return;
        List<Integer> list = null;
        if (mapList.size() >= (index+1)) {
            list = mapList.get(index);
        }
        if (list == null) {
            list = new ArrayList<>();
            mapList.add(list);
        }
        if (node.left != null) list.add(node.left.val);
        if (node.right != null) list.add(node.right.val);
        mapList.set(index, list);
        if (node.left != null) levelOrderBottomCommon(node.left, mapList, index+1);
        if (node.right != null) levelOrderBottomCommon(node.right, mapList, index+1);
    }
}

