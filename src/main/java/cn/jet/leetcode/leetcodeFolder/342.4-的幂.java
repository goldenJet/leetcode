/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 *
 * https://leetcode-cn.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (49.07%)
 * Likes:    136
 * Dislikes: 0
 * Total Accepted:    31.3K
 * Total Submissions: 63.6K
 * Testcase Example:  '16'
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 16
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: false
 * 
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * 
 */

// @lc code=start
class Solution {
    // 思路：用补码与原数进行与运算（&），
    // 0x55555555 其实就是 1010101010101010101010101010101 (偶数位为0，奇数位为1）
    public boolean isPowerOfFour(int num) {
        int x = 0x55555555;
        return (num > 0) && ((num&(num-1))==0) && ((num&x) == num);
    }
}
// @lc code=end

