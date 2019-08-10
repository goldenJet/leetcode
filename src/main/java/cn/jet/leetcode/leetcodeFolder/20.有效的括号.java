import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (39.14%)
 * Likes:    964
 * Dislikes: 0
 * Total Accepted:    104.3K
 * Total Submissions: 266.5K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s == "" || s == " " || s.length() == 0) {
            return true;
        }

        int length = s.length();
        if (length % 2 != 0)
            return false;

        Map<Character, Byte> map = new HashMap<Character, Byte>() {
            {
                put('(', (byte) -1);
                put('[', (byte) -2);
                put('{', (byte) -3);
                put(')', (byte) 1);
                put(']', (byte) 2);
                put('}', (byte) 3);
            }
        };

        List<Byte> list = new ArrayList<>();
        list.add(map.get(s.charAt(0)));
        int listLength = 1;

        for (int i = 1; i < length; i++) {
            byte temp = map.get(s.charAt(i));
            if (temp < 0) {
                list.add(temp);
                listLength++;
            } else {
                if (listLength == 0) {
                    list.add(temp);
                    break;
                } else {
                    if (list.get(listLength - 1) + temp == 0) {
                        list.remove(listLength - 1);
                        listLength--;
                    } else {
                        break;
                    }
                }
            }
        }

        return listLength == 0;
    }
}
