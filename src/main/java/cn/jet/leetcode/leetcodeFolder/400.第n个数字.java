/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第N个数字
 *
 * https://leetcode-cn.com/problems/nth-digit/description/
 *
 * algorithms
 * Easy (33.25%)
 * Likes:    70
 * Dislikes: 0
 * Total Accepted:    4.7K
 * Total Submissions: 14.1K
 * Testcase Example:  '3'
 *
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * 
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 2^31)。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * 3
 * 
 * 输出:
 * 3
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * 11
 * 
 * 输出:
 * 0
 * 
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 * 
 * 
 */
class Solution {
    public int findNthDigit(int n) {
        int result = 9;
        int s = 0;
        double r0 = 0;
        double r1 = 0;
        while (r1 < n) {
            s++;
            r0 = r1;
            r1 = 9 * s * Math.pow(10, s-1) + r1;
        }

        if (r0 != n){
            double b = 0;
            for (int i = 0; i < s-1; i++) {
                b += 9 * Math.pow(10, i);
            }
            // 暴力破解，待优化
            while (r0 < n) {
                b++;
                r0 += s;
            }
            int tempB = Integer.valueOf(Math.round(b) + "");
            //int tempB = Integer.parseInt(String.valueOf(b));

            if (r0 > n) {
                for (int j = 0; j < (r0 - n); j++) {
                    tempB = tempB / 10;
                }
            }
            result = tempB % 10;
        }

        return result;

        // 暴力破解
        /*int result = 0;
        int i = 0;
        int index = 0;
        int jumpSize = 1;
        int jumpLengthAll = 10;
        int jumpLengthNow = 10;
        while (index < n) {
            i++;
            jumpLengthNow--;
            if (jumpLengthNow == 0) {
                jumpLengthNow = jumpLengthAll * 10 - jumpLengthAll;
                jumpLengthAll = jumpLengthAll * 10;
                jumpSize++;
            }
            index += jumpSize;
            result = i%10;
            if(i == 99) {
                System.out.println(1);
            }
        }
        if (index > n) {
            for (int j = 0; j < (index - n); j++) {
                i = i / 10;
            }
            result = i % 10;
        }
        return result;*/
    }
}

