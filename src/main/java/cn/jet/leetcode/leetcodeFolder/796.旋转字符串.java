/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 */

// @lc code=start
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s == null && goal == null) return true;
        if (s == null || goal == null) return false;
        if (s.equals("") && goal.equals("")) return true;
        int l1, l2;
        if ((l1 = s.length()) != (l2 = goal.length())) return false;
        char[] s1 = s.toCharArray();
        char[] s2 = goal.toCharArray();
        int start = 0, end = 0, i1 = 0, i2 = 0;
        while (start < l1 && end < l1) {
            for (int i = 0; i < l2; i++) {
                i2 = i;
                if (i1 < l1) {
                    if (s2[i] == s1[i1]) {
                        i1 ++;
                        end = i1;
                    } else {
                        start++;
                        i1 = end = start;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (start >= l1) return false;
        for (int x = 0, y = i2; x < start; x++, y++) {
            if(s1[x] != s2[y]) return false;
        }
        return true;
    }
}
// @lc code=end

