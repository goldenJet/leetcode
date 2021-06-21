/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        // plan A：起始位置从0开始递增，结束位置从起始位置递增，即子串往两边释放，双层遍历判断子串是否是回文
        int sum = 0, start, end;
        for (int i = 0; i < s.length(); i++) {
            // 奇数对称
            start = end = i;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                sum++;
                start--;
                end++;
            }
            // 偶数对称
            start = i; end = i+1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                sum++;
                start--;
                end++;
            }
        }
        return sum;
        // plan B：起始位置从0开始递增，结束位置从末尾开始递减，即子串往中间回收，双层遍历判断子串是否是回文
        /*int length = s.length(), sum = length, end;
        boolean match = true;
        for (int i = 0; i < length-1; i++) {
            end = length-1;
            while (end > i) {
                match = true;
                for (int x = i, y = end; x < y; x++, y--) {
                    if (s.charAt(x) != s.charAt(y)) {
                        match = false;
                        break;
                    }
                }
                if (match) sum++;
                end--;
            }
        }
        return sum;*/
    }
}
// @lc code=end

