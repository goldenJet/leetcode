/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        int cur = 0, ans = 0;
        int length = nums.length;
        // 避免扩容
        Map<Integer, Integer> map = new HashMap<>(length, 1.05f);
        map.put(0,-1);
        for (int i = 0; i < length; i++) {
            // 遇到 0 减一；遇到 1 加一
            nums[i] = nums[i] == 0 ? --cur : ++cur;
            if (map.containsKey(cur)) {
                // 关于长度为什么不是 i - map.get(cur) + 1
                // 可以参考一下答主你问我答第一个回答的图片
                // 当 map 中存在一样的 key 时
                // 数组中满足条件的位置应该是[map.get(cur) + 1, i]
                ans = Math.max(ans, i - map.get(cur));
            } else {
                map.put(cur, i);
            }
        }
        return ans;
    }
}
// @lc code=end

