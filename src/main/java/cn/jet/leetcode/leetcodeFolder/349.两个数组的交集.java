/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Byte> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, (byte)1);
        }
        for (int i : nums2) {
            if (map.containsKey(i)) {
                if (map.get(i) == 1) {
                    map.put(i, (byte)2);
                    list.add(i);
                }
            }
        }
        int[] ints = new int[list.size()];
//        return list.toArray(ints);
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
// @lc code=end

