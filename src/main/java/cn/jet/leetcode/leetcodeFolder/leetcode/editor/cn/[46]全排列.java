//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2789 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 1) return Arrays.asList(Arrays.asList(nums[0]));
        List<List<Integer>> rst = new ArrayList<>();

        // 1. 选定一个数
        for (int i = 0; i < nums.length; i++) {
            // 2. 递归求剩余数的全排列
            int[] subNums = new int[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                if (j < i) subNums[j] = nums[j];
                else if (j > i) subNums[j - 1] = nums[j];
            }
            List<List<Integer>> subRst = permute(subNums);
            // 3. 将选定的数与剩余数的全排列组合
            for (List<Integer> subList : subRst) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(subList);
                rst.add(list);
            }
        }

        return rst;
    }

    private int factorial(int x) {
        if (x == 1) return 1;
        return x * factorial(x - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
