/*
 * @lc app=leetcode.cn id=1716 lang=java
 *
 * [1716] 计算力扣银行的钱
 */

// @lc code=start
class Solution {
    public int totalMoney(int n) {
        int r = 1;
        for (int i = 2, t = 1; i <= n; i++) {
            t++;
            if (i % 7 == 1) {
                t = (i-1) / 7 + 1;
            }
            r += t;
        }
        return r;
    }
}
// @lc code=end

