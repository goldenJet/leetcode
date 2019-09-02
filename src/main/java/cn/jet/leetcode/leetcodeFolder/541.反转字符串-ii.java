/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 *
 * https://leetcode-cn.com/problems/reverse-string-ii/description/
 *
 * algorithms
 * Easy (48.37%)
 * Likes:    43
 * Dislikes: 0
 * Total Accepted:    6.6K
 * Total Submissions: 13.6K
 * Testcase Example:  '"abcdefg"\n2'
 *
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k
 * 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 * 
 * 示例:
 * 
 * 
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 
 * 
 * 要求:
 * 
 * 
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 * 
 * 
 */
class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s == "" || s.length() == 0) return s;
        if (k == 0 || k == 1) return s;
        int lastLength = s.length(), first = 0;
        String result = "";
        while(lastLength > 0){
            if (lastLength < 2 * k && lastLength >= k) {
                result += reverseStrCommon(s.substring(first, first+k));
                result += s.substring(first+k, first+lastLength);
                lastLength = 0;
            } else if (lastLength < k) {
                result += reverseStrCommon(s.substring(first, first+lastLength));
                lastLength = 0;
            } else {
                result += reverseStrCommon(s.substring(first, first+k));
                result += s.substring(first+k, first+k+k);
                first = first+k+k;
                lastLength = lastLength - k - k;
            }
        }
        return result;
    }
    public String reverseStrCommon(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

