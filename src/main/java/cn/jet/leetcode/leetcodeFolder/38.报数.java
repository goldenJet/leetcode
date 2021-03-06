/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (51.75%)
 * Likes:    281
 * Dislikes: 0
 * Total Accepted:    42.2K
 * Total Submissions: 81.4K
 * Testcase Example:  '1'
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 
 * 
 */
class Solution {
    public String countAndSay(int n) {
        return countAnySayCommon(--n, "1");
    }
    public String countAnySayCommon(int n, String s) {
        if (n == 0) return s;
        StringBuilder sb = new StringBuilder();
        char temp = s.charAt(0);
        int num = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == temp) {
                num ++;
            } else {
                sb.append(num).append(temp);
                temp = s.charAt(i);
                num = 1;
            }
        }
        if (num > 0) {
            sb.append(num).append(temp);
        }
        return countAnySayCommon(--n, sb.toString());
    }
}

