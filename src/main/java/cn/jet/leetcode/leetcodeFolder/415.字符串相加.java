/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 *
 * https://leetcode-cn.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (51.72%)
 * Likes:    248
 * Dislikes: 0
 * Total Accepted:    72K
 * Total Submissions: 139.1K
 * Testcase Example:  '"0"\n"0"'
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * 
 * 
 */

// @lc code=start
class Solution {
    // 思路就是从末位开始挨个进行相加
    public String addStrings(String num1, String num2) {
        int t = 0, i = num1.length(), j = num2.length();
        StringBuilder sb = new StringBuilder();
        while (i > 0 || j > 0 || t > 0) {
            if (i > 0) t += num1.charAt(--i) - '0';
            if (j > 0) t += num2.charAt(--j) - '0';
            sb.append(t % 10);
            t = t / 10;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

