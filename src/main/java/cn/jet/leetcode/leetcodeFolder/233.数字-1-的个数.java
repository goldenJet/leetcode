/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 *
 * https://leetcode-cn.com/problems/number-of-digit-one/description/
 *
 * algorithms
 * Hard (36.89%)
 * Likes:    174
 * Dislikes: 0
 * Total Accepted:    11.2K
 * Total Submissions: 29.7K
 * Testcase Example:  '13'
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 
 * 示例:
 * 
 * 输入: 13
 * 输出: 6 
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * 
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        if (n < 1) return 0;
        int len = getLenOfNum(n);
        if (len == 1) return 1;
        int tmp = (int) Math.pow(10, len - 1);
        int first = n / tmp; // 获取n的最高位数字
        int firstOneNum = first == 1 ? n % tmp + 1 : tmp; // 获取n的最高位为1时有多少个数字
        int otherOneNUm = first * (len - 1) * (tmp / 10); // 在介于n % tmp到n之间的数字中，除了最高位为1，其余各个数字分别为1 的总数和
        return firstOneNum + otherOneNUm + countDigitOne(n % tmp);
    }
    private static int getLenOfNum(int n) {
        int len = 0;
        while (n != 0) {
            len++;
            n /= 10;
        }
        return len;
    }
}
// @lc code=end

