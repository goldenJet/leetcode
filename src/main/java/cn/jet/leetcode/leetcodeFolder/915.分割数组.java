/*
 * @lc app=leetcode.cn id=915 lang=java
 *
 * [915] 分割数组
 */

// @lc code=start
class Solution {
    public int partitionDisjoint(int[] nums) {
        int lmax = nums[0], index = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < lmax) {
                lmax = max;
                index = i;
            }
        }
        return index + 1;
    }
}
// @lc code=end

