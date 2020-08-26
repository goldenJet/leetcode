/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 *
 * https://leetcode-cn.com/problems/perfect-number/description/
 *
 * algorithms
 * Easy (38.31%)
 * Likes:    69
 * Dislikes: 0
 * Total Accepted:    17.1K
 * Total Submissions: 44.5K
 * Testcase Example:  '28'
 *
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 
 * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 输入的数字 n 不会超过 100,000,000. (1e8)
 * 
 */

// @lc code=start
class Solution {
    // 思路：算出每个正因子再相加，性能其实不佳
    public boolean checkPerfectNumber(int num) {
        if (num < 2) return false;
        int count = 1, i = 2;
        while (i <= Math.sqrt(num)) {
            if (num % i == 0) {
                count += i;
                count += num/i;
            }
            i++;
        }
        return count == num;
    }
}
// @lc code=end

