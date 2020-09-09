/*
 * @lc app=leetcode.cn id=665 lang=java
 *
 * [665] 非递减数列
 *
 * https://leetcode-cn.com/problems/non-decreasing-array/description/
 *
 * algorithms
 * Easy (22.52%)
 * Likes:    339
 * Dislikes: 0
 * Total Accepted:    25.8K
 * Total Submissions: 113.9K
 * Testcase Example:  '[4,2,3]'
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 * 
 * 
 */

// @lc code=start
class Solution {
    // 思路：先找有几个波谷，超过一个的，直接 false，然后再分情况讨论是采用将波谷上拉的操作，还是将前一个波峰下沉的操作
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 2) return true;
        int n1 = nums[0], n2;
        int t = 0, i = 1, l = nums.length, x = 0;
        while (t < 3 && i < l) {
            n2 = nums[i];
            if (n1 > n2) {
                t++;
                x = i;
            }
            n1 = n2;
            i++;
        }
        // 没有波谷
        if (t == 0) return true;
        // 不止一个波谷
        if (t > 1) return false;
        // 波谷在结尾
        if (x == l-1) return true;
        int A = x == 1 ? - 10^5 : nums[x-2];
        int B = nums[x-1];
        int C = nums[x];
        int D = nums[x+1];
        // plan a 前波峰下沉
        if (C >= A) return true;
        // plan b 波谷上拉
        if (D > B) return true;
        return false;
    }
}
// @lc code=end

