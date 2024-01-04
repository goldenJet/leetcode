//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2721 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<>();
        if ("".equals(digits)) return rst;
        String[] strOri = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 234
        // abc def ghi

        // dg dh di
        // eg eh ei
        // fg fh fi
        char[] dc = digits.toCharArray(); // [2 3 4]
        List<List<String>> ds = new ArrayList<>();
        for (char c : dc) {
            ds.add(Arrays.asList(strOri[c - '0'].split(""))); // [[a b c] [d e f] [g h i]]
        }
        if (ds.size() == 1) return ds.get(0);
        int index = ds.size() - 2;
        rst = add(ds.get(index), ds.get(index + 1));

        while (--index >= 0) {
            rst = add(ds.get(index), rst);
        }

        return rst;
    }

    public List<String> add(List<String> l1, List<String> l2) {
        List<String> result = new ArrayList<>();
        l1.forEach(s1 -> l2.forEach(s2 -> result.add(s1 + s2)));
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
