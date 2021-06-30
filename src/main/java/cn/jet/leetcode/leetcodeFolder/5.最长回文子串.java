/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        int midLength = (length+1)/2;
        int max = 0;
        String result = null;
        for (int x = 0; x < length; x++) {
            for (int y = length-1; y >= x ; y--) {
                boolean boo = true;
                for (int a = x, b = y; a <= b; a++,b--) {
                    if (s.charAt(a) != s.charAt(b)) {
                        boo = false;
                        break;
                    }
                }
                if (boo) {
                    if (y-x+1 >= max) {
                        result = s.substring(x, y+1);
                        max = y-x+1;
                    }
                    break;
                }
            }

        }
        return result;
    }
}
// @lc code=end

