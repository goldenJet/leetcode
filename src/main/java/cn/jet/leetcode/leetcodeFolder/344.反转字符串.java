/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 *
 * https://leetcode-cn.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (70.95%)
 * Likes:    264
 * Dislikes: 0
 * Total Accepted:    167.6K
 * Total Submissions: 236K
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * 
 */

// @lc code=start
class Solution {
    // 异或运算（^）是可以用来交换位置的，而不用新增空间
    public void reverseString(char[] s) {
        char a, b;
        int length = s.length;
        for (int i = 0; i < (length+1) / 2; i++) {
            a = s[i];
            b = s[length-i-1];
            a = (char)(a^b);
            b = (char)(a^b);
            a = (char)(a^b);
            s[i] = a;
            s[length-i-1] = b;
        }
    }
}
// @lc code=end

