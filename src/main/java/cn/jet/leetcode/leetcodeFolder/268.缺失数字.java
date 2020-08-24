/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 *
 * https://leetcode-cn.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (56.65%)
 * Likes:    305
 * Dislikes: 0
 * Total Accepted:    81.7K
 * Total Submissions: 144K
 * Testcase Example:  '[3,0,1]'
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [3,0,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 
 * 
 * 
 * 
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 
 */

// @lc code=start
class Solution {
    // 思路就是求和，然后减去所有的数，得到的值便是缺失的数字
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = length*(length+1)/2;
        for(int num : nums){
        	sum = sum - num;
        }
    	
    	return sum;
    }
}
// @lc code=end

