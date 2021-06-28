/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    // 思路：数组遍历一遍，存到map中去，value就是index值
    // 如果map中已存在，则判断当前i和上一个index的差值是否小于k
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                Integer index = map.get(num);
                if (i - index <= k) return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
// @lc code=end

