/*
 * @lc app=leetcode.cn id=554 lang=java
 *
 * [554] 砖墙
 */

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> sum = new HashMap<>();
//        int[] sum = new int[wall.get(0).stream().mapToInt(Integer::intValue).sum()-1];
        int index, max = 0;
        for (List<Integer> integers : wall) {
            index = -1;
            for (int i = 0; i < integers.size()-1; i++) {
                int integer = integers.get(i);
                index+=integer;
                /*sum[index] = sum[index] + 1;
                max = Math.max(sum[index], max);*/
                sum.put(index, sum.containsKey(index) ? sum.get(index) + 1 : 1);
                max = Math.max(sum.get(index), max);
            }
        }
        return wall.size() - max;
    }
}
// @lc code=end

