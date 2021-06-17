/*
 * @lc app=leetcode.cn id=1678 lang=java
 *
 * [1678] 设计 Goal 解析器
 */

// @lc code=start
class Solution {
    public String interpret(String command) {
        //return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
        boolean r1 = false;
        char[] chars = command.toCharArray();
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < chars.length; i++) {
            c = chars[i];
            if ('G' == c) {
                sb.append(c);
                r1 = false;
            } else if ('(' == c) {
                r1 = true;
            } else if ('a' == c) {
                r1 = false;
                i++;
            } else {
                if (r1) {
                    sb.append('o');
                } else {
                    sb.append("al");

                }
            }

        }
        return sb.toString();
    }
}
// @lc code=end

