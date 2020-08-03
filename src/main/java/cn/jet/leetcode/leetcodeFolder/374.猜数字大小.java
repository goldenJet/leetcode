/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 *
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/description/
 *
 * algorithms
 * Easy (45.09%)
 * Likes:    71
 * Dislikes: 0
 * Total Accepted:    27.7K
 * Total Submissions: 61.5K
 * Testcase Example:  '10\n6'
 *
 * 猜数字游戏的规则如下：
 * 
 * 
 * 每轮游戏，系统都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，系统会告诉你这个数字比系统选出的数字是大了还是小了。
 * 
 * 
 * 你可以通过调用一个预先定义好的接口 guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * 
 * -1 : 系统选出的数字比你猜测的数字小
 * ⁠1 : 系统选出的数字比你猜测的数字大
 * ⁠0 : 恭喜！你猜对了！
 * 
 * 
 * 
 * 
 * 示例 :
 * 
 * 输入: n = 10, pick = 6
 * 输出: 6
 * 
 */

// @lc code=start
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return guseeNumberCommon(0, n, n/2);
    }

    public int guseeNumberCommon(int left, int right, int mid) {
        int result = guess(mid);
        if ( result== 0) {
            return mid;
        } else if (result == 1) {
            left = mid+1;
        } else {
            right = mid;
        }
        mid = left + (right-left)/2;
        return guseeNumberCommon(left, right, mid);
    }
}
// @lc code=end

