import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 *
 * https://leetcode-cn.com/problems/fizz-buzz/description/
 *
 * algorithms
 * Easy (60.83%)
 * Likes:    32
 * Dislikes: 0
 * Total Accepted:    18.4K
 * Total Submissions: 30.3K
 * Testcase Example:  '1'
 *
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 * 
 * 示例：
 * 
 * n = 15,
 * 
 * 返回:
 * [
 * ⁠   "1",
 * ⁠   "2",
 * ⁠   "Fizz",
 * ⁠   "4",
 * ⁠   "Buzz",
 * ⁠   "Fizz",
 * ⁠   "7",
 * ⁠   "8",
 * ⁠   "Fizz",
 * ⁠   "Buzz",
 * ⁠   "11",
 * ⁠   "Fizz",
 * ⁠   "13",
 * ⁠   "14",
 * ⁠   "FizzBuzz"
 * ]
 * 
 * 
 */
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        int jump3 = 1, jump5 = 1;
        for (int i = 1; i <= n; i++) {
            if (jump3 == 3 && jump5 == 5) {
                result.add("FizzBuzz");
                jump3 = 1;
                jump5 = 1;
            } else if (jump3 == 3) {
                result.add("Fizz");
                jump3 = 1;
                jump5++;
            } else if (jump5 == 5) {
                result.add("Buzz");
                jump5 = 1;
                jump3++;
            } else {
                result.add(i + "");
                jump3++;
                jump5++;
            }
        }
        return result;
    }
}

