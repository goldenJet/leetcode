/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g = 0;
        boolean b = true;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] < cost[i]) continue;
            g+=gas[i];
            g-=cost[i];
            if (g < 0) continue;
            for (int x = i+1; x < gas.length; x++) {
                g+=gas[x];
                g-=cost[x];
                if (g < 0) {
                    b = false;
                    break;
                }
                b = true;
            }
            if (i > 0) {
                for (int x = 0; x < i; x++) {
                    g+=gas[x];
                    g-=cost[x];
                    if (g < 0) {
                        b = false;
                        break;
                    }
                }
            }
            if (b) return i;
            b = true;
            g = 0;
        }
        return -1;
    }
}
// @lc code=end

