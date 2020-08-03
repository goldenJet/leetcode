/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (29.70%)
 * Likes:    400
 * Dislikes: 0
 * Total Accepted:    68.7K
 * Total Submissions: 198.8K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 
 * 示例:
 * 
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] b = new boolean[n]; // 默认所有位置均为 false，即先假设每个位置都是质数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!b[i]) {
                count++; // 每个非质数必定是由前面的某个数乘起来的
                for (int j = i*2; j < n; j+=i) {
                    b[j] = true; // i坐标的 2倍、3倍、4倍处的数必然非质数
                }
            }
        }
        return count;
    }
}
// @lc code=end

