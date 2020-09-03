/*
 * @lc app=leetcode.cn id=628 lang=java
 *
 * [628] 三个数的最大乘积
 *
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/description/
 *
 * algorithms
 * Easy (50.33%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    25.6K
 * Total Submissions: 50.8K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3]
 * 输出: 6
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,3,4]
 * 输出: 24
 * 
 * 
 * 注意:
 * 
 * 
 * 给定的整型数组长度范围是[3,10^4]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * 
 * 
 */

// @lc code=start
class Solution {
    // 思路就是排序，然后取后三个数相乘，但是要注意前两个是负数的情况
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        // 防止出现负数
        if (nums[1] < 0) {
            if (nums[0] * nums[1] > nums[n-2] * nums[n-3]) {
                return nums[0] * nums[1] * nums[n-1];
            } else {
                return nums[n-1] * nums[n-2] * nums[n-3];
            }
        } else {
            return nums[n-1] * nums[n-2] * nums[n-3];
        }
    }
}
// @lc code=end

