/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len == 0) return true;
        int[] pointer = new int[numCourses]; // 记录每个课程被依赖的次数
        for (int[] p : prerequisites) ++pointer[p[1]];
        boolean[] removed = new boolean[len]; // 标记prerequisites中的元素是否被移除
        int remove = 0;// 移除的元素数量
        while (remove < len) {
            int currRemove = 0; // 本轮移除的元素数量
            for (int i = 0; i < len; i++) {
                if (removed[i]) continue;// 被移除的元素跳过
                int[] p = prerequisites[i];
                if (pointer[p[0]] == 0) {// 如果被安全课程指向
                    --pointer[p[1]];// 被指向次数减1
                    removed[i] = true;
                    ++currRemove;
                }
            }
            if (currRemove == 0) return false;// 如果一轮跑下来一个元素都没移除，则没必要进行下一轮
            remove += currRemove;
        }
        return true;
    }
}
// @lc code=end

