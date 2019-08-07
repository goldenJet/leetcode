/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] reuslt = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    reuslt[0] = i;
                    reuslt[1] = j;
                }
            }
        }
        return reuslt;
    }

}

