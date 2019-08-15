/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/description/
 *
 * algorithms
 * Easy (46.69%)
 * Likes:    1113
 * Dislikes: 0
 * Total Accepted:    80.4K
 * Total Submissions: 172K
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * 
 * 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int resultSingle = nums[0];
        List<Integer> resultList = new ArrayList<>();
        List<Integer> resultTempList = new ArrayList<>();
        boolean firstFlag = true;
        boolean lessZeroFlag = false;
        int indexLast = 0;
        for (int num : nums) {
            if (num >= resultSingle) {
                resultSingle = num;
            }
            if (firstFlag) {
                if (num > 0) {
                    resultList.add(num);
                    indexLast = resultList.size() - 1;
                    firstFlag = false;
                    lessZeroFlag = false;
                }
            } else {
                if (num >= 0) {
                    if (resultTempList.size() < resultList.size()) resultTempList.add(resultList.get(resultList.size() - 1));
                    for (int i = indexLast; i < resultList.size(); i++) {
                        if (lessZeroFlag) {
                            if (resultList.get(i) + num >= 0) {
                                resultList.set(i, resultList.get(i) + num);
                            } else {
                                resultList.set(i, resultTempList.get(i));
                                if (i == resultList.size() - 1) {
                                    firstFlag = true;
                                    indexLast = resultList.size() - 1;
                                } else {
                                    indexLast = i + 1;
                                }
                            }

                        } else {
                            resultList.set(i, resultList.get(i) + num);
                        }
                    }
                    lessZeroFlag = false;
                } else {
                    if (!lessZeroFlag || resultTempList.size() == 0) resultTempList.add(resultList.get(resultList.size() - 1));
                    for (int i = indexLast; i < resultList.size(); i++) {
                        int temp = resultList.get(i);
                        if (temp + num > 0) {
                            resultList.set(i, resultList.get(i) + num);
                        } else {
                            if (resultList.get(i) < resultTempList.get(i)) {
                                resultList.set(i, resultTempList.get(i));
                            }
                            if (i == resultList.size() - 1) {
                                firstFlag = true;
                                indexLast = resultList.size() - 1;
                            } else {
                                indexLast = i + 1;
                            }
                        }
                    }
                    lessZeroFlag = true;
                }
            }

        }
        for (Integer integer : resultList) {
            if (integer > resultSingle) resultSingle = integer;
        }
        for (Integer integer : resultTempList) {
            if (integer > resultSingle) resultSingle = integer;
        }
        return resultSingle;
    }
}

