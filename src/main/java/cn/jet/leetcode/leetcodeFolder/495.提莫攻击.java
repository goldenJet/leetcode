/*
 * @lc app=leetcode.cn id=495 lang=java
 *
 * [495] 提莫攻击
 */

// @lc code=start
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0, lastT;
        if (timeSeries.length == 1) return duration;
        lastT = timeSeries[0];
        for (int i = 1; i < timeSeries.length; i++) {
            int timeSery = timeSeries[i];
            result += Math.min(timeSery - lastT, duration);
            lastT = timeSery;
        }
        result+=duration;
        return result;
    }
}
// @lc code=end

