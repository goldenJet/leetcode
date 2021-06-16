/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] t = new int[n + 1];
        int[] ted = new int[n + 1];
        for (int[] ints : trust) {
            t[ints[0]] = 1;
            ted[ints[1]]++;
        }
        int result = -1;
        for (int i = 1; i <= n; i++) {
            int b = t[i];
            if (b == 0) {
                if (result == -1) {
                    result = i;
                } else {
                    return -1;
                }
            }
        }
        if (result > -1) {
            if (ted[result] + 1 != n) return -1;
        }
        return result;
    }
}
// @lc code=end

