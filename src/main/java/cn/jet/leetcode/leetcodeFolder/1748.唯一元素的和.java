/*
 * @lc app=leetcode.cn id=1748 lang=java
 *
 * [1748] 唯一元素的和
 *
 * https://leetcode-cn.com/problems/sum-of-unique-elements/description/
 *
 * algorithms
 * Easy (74.91%)
 * Likes:    7
 * Dislikes: 0
 * Total Accepted:    10.2K
 * Total Submissions: 13.6K
 * Testcase Example:  '[1,2,3,2]'
 *
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * 
 * 请你返回 nums 中唯一元素的 和 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 * 
 * 
 * 示例 2：
 * 
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 * 
 * 
 * 示例 3 ：
 * 
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    public int sumOfUnique(int[] nums) {
        byte[] ints = new byte[101];
        for (int num : nums) {
            if (ints[num] == 0) {
                ints[num] = 1;
            } else {
                ints[num] = 2;
            }
        }
        int result = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) result += i;
        }
        return result;
    }
}
// @lc code=end

