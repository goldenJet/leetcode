/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 *
 * https://leetcode-cn.com/problems/heaters/description/
 *
 * algorithms
 * Easy (30.69%)
 * Likes:    151
 * Dislikes: 0
 * Total Accepted:    13.3K
 * Total Submissions: 43.1K
 * Testcase Example:  '[1,2,3]\n[2]'
 *
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * 
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 * 
 * 说明:
 * 
 * 
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 
 * 
 */

// @lc code=start
class Solution {
    // 思路：遍历house 和暖炉，找到每个house 到每个暖炉的最小距离，然后取他们中的最大距离即可
    public int findRadius(int[] houses, int[] heaters) {
        int maxLength = 0, minLength, temp;
        for (int house : houses) {
            minLength = Math.abs(house - heaters[0]);
            for (int j = 1; j < heaters.length; j++) {
                if ((temp = Math.abs(house - heaters[j])) < minLength) {
                    minLength = temp;
                }
            }
            maxLength = Math.max(maxLength, minLength);
        }
        return maxLength;
    }
}
// @lc code=end

