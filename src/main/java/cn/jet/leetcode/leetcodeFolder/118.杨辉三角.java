/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (63.67%)
 * Likes:    180
 * Dislikes: 0
 * Total Accepted:    34.2K
 * Total Submissions: 53.6K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    // 思路：简单粗暴的两层 for 循环
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 0) return null;
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        List<Integer> list0 = new ArrayList<>();
        list0.add(1);
        result.add(list0);
        if (numRows == 1) return result;
        List<Integer> listTemp = list0;
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(listTemp.get(j-1) + listTemp.get(j));
            }
            list.add(1);
            listTemp = list;
            result.add(list);
        }
        return result;
    }
}
// @lc code=end

