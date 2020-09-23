/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (61.65%)
 * Likes:    181
 * Dislikes: 0
 * Total Accepted:    70.6K
 * Total Submissions: 114.1K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */

// @lc code=start
class Solution {
    // 思路：简单的方式就是两层for循环，但是空间复杂度达不到 O(k)，然后在网上找到了一个关于杨辉三角的数的计算公式，问题迎刃而解
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long temp = 1;
        for (int i = 0; i <= rowIndex; i++) {
            result.add((int)temp);
            temp = temp * (rowIndex - i) / (i + 1);
        }
        return result;
    }
}
// @lc code=end

