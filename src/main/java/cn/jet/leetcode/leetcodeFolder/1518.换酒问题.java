/*
 * @lc app=leetcode.cn id=1518 lang=java
 *
 * [1518] 换酒问题
 */

// @lc code=start
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int a;
        while (numBottles >= numExchange) {
            a = numBottles / numExchange;
            result += a;
            numBottles = a + numBottles % numExchange;
        }
        return result;
    }
}
// @lc code=end

