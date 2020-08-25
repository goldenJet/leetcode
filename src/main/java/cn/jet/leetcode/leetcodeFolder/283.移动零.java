/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (61.96%)
 * Likes:    705
 * Dislikes: 0
 * Total Accepted:    197.2K
 * Total Submissions: 317.5K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    // 思路是快排，即指针 index 记录最左侧的【0】，然后将所有不为0的数都和它进行交换
    public void moveZeroes(int[] nums) {
        int index = -1;
        for(int i = 0; i < nums.length; i++){
            int now = nums[i];
            if(now != 0) {
                if(index < 0) {
                    continue;
                }
                nums[index++] = now;
                nums[i] = 0;
            } else {
                if(index < 0) {
                    index = i;
                }
            }
        }
    }
}
// @lc code=end

