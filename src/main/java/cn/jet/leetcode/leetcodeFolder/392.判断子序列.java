/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        // 数据初始化
        List<List<Integer>> lists = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            lists.add(new ArrayList<>());
        }
        char[] chars = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int listsIndex = c - 'a';
            lists.get(listsIndex).add(i);
        }
        // 正式开始
        int lastIndex = -1, nowIndex = -1;
        for (char c : s.toCharArray()) {
            int listsIndex = c - 'a';
            List<Integer> integerList = lists.get(listsIndex);
            for (Integer i : integerList) {
                if (i > lastIndex) {
                    nowIndex = i;
                    break;
                }
            }
            if (lastIndex == nowIndex) return false;
            lastIndex = nowIndex;
        }
        return true;
    }
}
// @lc code=end

