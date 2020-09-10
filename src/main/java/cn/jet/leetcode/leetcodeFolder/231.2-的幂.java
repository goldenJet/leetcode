/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (48.43%)
 * Likes:    239
 * Dislikes: 0
 * Total Accepted:    77.8K
 * Total Submissions: 160.2K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 2^0 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 2^4 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    // 思路：2的幂次方，这种数的特点是除了高位是1以外，其余全都是0，将其减一之后后面的位上面则全是1，
    // 两个数进行与运算（&），则结果必然是 0
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        return (n & (n-1)) == 0;
    }
}
// @lc code=end

