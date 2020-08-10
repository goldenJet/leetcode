/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 *
 * https://leetcode-cn.com/problems/keyboard-row/description/
 *
 * algorithms
 * Easy (69.42%)
 * Likes:    103
 * Dislikes: 0
 * Total Accepted:    18.9K
 * Total Submissions: 27.2K
 * Testcase Example:  '["Hello","Alaska","Dad","Peace"]'
 *
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 * 
 */

// @lc code=start
class Solution {
    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('q', 1);
            put('w', 1);
            put('e', 1);
            put('r', 1);
            put('t', 1);
            put('y', 1);
            put('u', 1);
            put('i', 1);
            put('o', 1);
            put('p', 1);
            put('a', 2);
            put('s', 2);
            put('d', 2);
            put('f', 2);
            put('g', 2);
            put('h', 2);
            put('j', 2);
            put('k', 2);
            put('l', 2);
            put('z', 3);
            put('x', 3);
            put('c', 3);
            put('v', 3);
            put('b', 3);
            put('n', 3);
            put('m', 3);
        }};
        List<String> result = new ArrayList<>();
        int index; boolean matchIndex;
        for (String word : words) {
            char f = word.charAt(0);
            if(f >= 'A' && f <= 'Z') f = (char)(f+32);
            index = map.get(f);
            matchIndex = true;
            for (char c : word.toCharArray()) {
                if(c >= 'A' && c <= 'Z') c = (char)(c+32);
                if (index != map.get(c)) {
                    matchIndex = false;
                    break;
                }
            }
            if (matchIndex) result.add(word);
        }
        return result.toArray(new String[]{});
    }
}
// @lc code=end

