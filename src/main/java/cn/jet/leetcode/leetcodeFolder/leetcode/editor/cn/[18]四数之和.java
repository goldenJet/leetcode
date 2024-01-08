//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 双指针 排序 👍 1834 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<>();
        Arrays.sort(nums); // [2 2 2 2]
        for (int x = 0; x < nums.length - 3; x++) {
            int a = nums[x];
            //if (x != 0 && a > 0) break;

            int l = x + 1, y = l + 1, r = nums.length - 1;
            while (l < r-1) {
                while (y < r) {
                    int b = nums[l], c = nums[y], d = nums[r];
                    int sum = a + b + c + d;
                    if (sum == target) {
                        rst.add(Arrays.asList(a, b, c, d));
                        while (y < r && nums[y] == nums[y+1]) y++;
                        while (y < r && nums[r] == nums[r-1]) r--;
                        y++;
                        r--;
                    } else if (sum < target) {
                        y++;
                    } else {
                        r--;
                        y = l + 1;
                    }
                }
                l++;
                y = l + 1;
                r = nums.length - 1;
            }
        }
        return rst;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
