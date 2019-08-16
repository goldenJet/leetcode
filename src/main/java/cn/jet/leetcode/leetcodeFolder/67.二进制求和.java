import com.sun.javafx.util.TempState;

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (49.87%)
 * Likes:    229
 * Dislikes: 0
 * Total Accepted:    34.7K
 * Total Submissions: 69.4K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int al = ca.length;
        int bl = cb.length;
        if (al >= bl) {
            int c = al - bl;
            int first = 0;
            for (int i = bl - 1; i >= 0; i--) {
                int temp = Integer.parseInt(String.valueOf(ca[i+c])) + Integer.parseInt(String.valueOf(cb[i])) + first;
                if  (temp >=2 ) {
                    first = 1;
                } else {
                    first = 0;
                }
                if (temp % 2 == 0) {
                    ca[i+c] = '0';
                } else {
                    ca[i+c] = '1';
                }
            }

            for (int i = al - 1 - bl; i >= 0; i--) {
                int temp = Integer.parseInt(String.valueOf(ca[i])) + first;
                if  (temp ==2 ) {
                    first = 1;
                } else {
                    first = 0;
                }
                if (temp % 2 == 0) {
                    ca[i] = '0';
                } else {
                    ca[i] = '1';
                }
            }

            StringBuilder sb = new StringBuilder();
            if (first != 0) sb.append("1");
            for (int i = 0; i < al; i++) {
                sb.append(ca[i]);
            }
            return sb.toString();
        } else {
            return addBinary(b, a);
        }
    }
}

