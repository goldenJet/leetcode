/*
 * @lc app=leetcode.cn id=1446 lang=java
 *
 * [1446] 连续字符
 */

// @lc code=start
class Solution {
    public int maxPower(String s) {
        if (s == null || s.equals("")) return 0; 
        char a = s.charAt(0);
        int l = 0, t = 0;
        for (char c : s.toCharArray()) {
            if (c == a) {
                t++;
                if (t > l) l = t;
            } else {
                t = 1;
            }
            a = c;
        }
        return l;
    }
}
// @lc code=end

