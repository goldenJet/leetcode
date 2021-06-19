/*
 * @lc app=leetcode.cn id=553 lang=java
 *
 * [553] 最优除法
 */

// @lc code=start
class Solution {
    public String optimalDivision(int[] nums) {
        int l;
        if ((l = nums.length) == 1) {
            return String.valueOf(nums[0]);
        }
        StringBuilder sb = new StringBuilder().append(nums[0]).append("/");
        if (l == 2) {
            sb.append(nums[1]);
        } else {
            sb.append("(");
            for (int i = 1; i < nums.length; i++) {
                sb.append(nums[i]).append("/");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append(")");
        }
        return sb.toString();
    }
}
// @lc code=end

