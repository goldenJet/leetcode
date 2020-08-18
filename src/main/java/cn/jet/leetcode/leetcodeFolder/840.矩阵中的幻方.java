/*
 * @lc app=leetcode.cn id=840 lang=java
 *
 * [840] 矩阵中的幻方
 *
 * https://leetcode-cn.com/problems/magic-squares-in-grid/description/
 *
 * algorithms
 * Easy (34.69%)
 * Likes:    38
 * Dislikes: 0
 * Total Accepted:    6.6K
 * Total Submissions: 18.9K
 * Testcase Example:  '[[4,3,8,4],[9,5,1,9],[2,7,6,2]]'
 *
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * 
 * 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: [[4,3,8,4],
 * ⁠     [9,5,1,9],
 * ⁠     [2,7,6,2]]
 * 输出: 1
 * 解释: 
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 * 
 * 而这一个不是：
 * 384
 * 519
 * 762
 * 
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) return 0;
        int result = 0;
        for (int y = 0; y < grid.length - 2; y++) {
            for (int x = 0; x < grid[0].length - 2; x++) {
                // 计数数字
                boolean[] numbers = new boolean[15];
                boolean nFlag = true;
                numbers[grid[y][x]] = true;numbers[grid[y][x+1]] = true;numbers[grid[y][x+2]] = true;
                numbers[grid[y+1][x]] = true;numbers[grid[y+1][x+1]] = true;numbers[grid[y+1][x+2]] = true;
                numbers[grid[y+2][x]] = true;numbers[grid[y+2][x+1]] = true;numbers[grid[y+2][x+2]] = true;
                for (int i = 1; i < 10; i++) {
                    nFlag &= numbers[i];
                }

                if (!nFlag) continue;
                // 中间数必为5
                if (grid[y+1][x+1] != 5) continue;
                // 另外，其实3x3的幻方，2、8必为斜对角，4、3、8必为一行，2、9、4必为一行，等，也就是说幻方是有规律的，没比较计算每行的和
                // 计算和
                int line1 = grid[y][x] + grid[y][x+1] + grid[y][x+2];
                int line2 = grid[y+1][x] + grid[y+1][x+1] + grid[y+1][x+2];
                int line3 = grid[y+2][x] + grid[y+2][x+1] + grid[y+2][x+2];
                int cell1 = grid[y][x] + grid[y+1][x] + grid[y+2][x];
                int cell2 = grid[y][x+1] + grid[y+1][x+1] + grid[y+2][x+1];
                int cell3 = grid[y][x+2] + grid[y+1][x+2] + grid[y+2][x+2];
                int l1 = grid[y][x] + grid[y+1][x+1] + grid[y+2][x+2];
                int l2 = grid[y][x+2] + grid[y+1][x+1] + grid[y+2][x];
                if (line1 == line2 && line2 == line3 && line3 == cell1 && cell1 == cell2 && cell2 == cell3 && cell3 == l1 && l1 == l2) result++;
            }
        }
        return result;
    }
}
// @lc code=end

