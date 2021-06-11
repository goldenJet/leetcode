/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 */

// @lc code=start
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int y = i;
            boolean add = true;
            while (y > 0) {
                int t = y % 10;
                if (t == 0 || i % t != 0) {
                    add = false;
                    break;
                }
                y /= 10;
            }
            if (add) result.add(i);
        }
        return result;
    }
}
// @lc code=end

