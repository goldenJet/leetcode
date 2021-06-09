/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int large = 0;
        for (int num : nums) {
            if (Math.abs(num) > large) large = num;
        }
        int[] ints = new int[large+1];
        for (int num : nums) {
            if (num >= 0) {
                if (ints[num] == 1) return true;
                ints[num] = 1;
            }
        }
        ints = new int[large+1];
        for (int num : nums) {
            if (num < 0) {
                if (ints[-num] == 1) return true;
                ints[-num] = 1;
            }
        }
        return false;
    }
}
// @lc code=end

