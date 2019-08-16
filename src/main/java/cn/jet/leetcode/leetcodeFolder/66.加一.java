/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (40.18%)
 * Likes:    328
 * Dislikes: 0
 * Total Accepted:    68.9K
 * Total Submissions: 170.9K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int first = 0;
        int length = digits.length;
        for (int i = length - 1; i >= 0; i-- ) {
            int temp = digits[i];
            if (temp == 9) {
                digits[i] = 0;
                if (i == 0) {
                    first = 1;
                }
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        if (first == 0) return digits;
        int[] result = new int[length + 1];
        result[0] = first;
        for (int i = 0; i < length; i++) {
            result[i+1] = digits[i];
        }
        return result;
    }
}

