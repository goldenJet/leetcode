/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 *
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (43.22%)
 * Likes:    184
 * Dislikes: 0
 * Total Accepted:    30.1K
 * Total Submissions: 69.3K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 
 * 示例1:
 * 
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 
 * 示例 4:
 * 
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * 
 */

// @lc code=start
class Solution {
    // 思路：pattern的每个字符和str中的每个字符串形成一个一一对应的匹配关系
    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        char[] chars = pattern.toCharArray();
        if (chars.length != split.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            String s = split[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(s)) return false;
            } else {
                if (map.containsValue(s)) return false;
                map.put(c, s);
            }
        }
        return true;
    }
}
// @lc code=end

