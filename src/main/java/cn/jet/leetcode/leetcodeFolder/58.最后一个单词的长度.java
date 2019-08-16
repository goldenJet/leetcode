/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (30.67%)
 * Likes:    128
 * Dislikes: 0
 * Total Accepted:    37.3K
 * Total Submissions: 121.3K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */
class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        boolean start = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == 32) {
                if (start) {
                    break;
                } else {
                    continue;
                }
            } else {
                start = true;
                result++;
            }
        }
        return result;
    }
}

