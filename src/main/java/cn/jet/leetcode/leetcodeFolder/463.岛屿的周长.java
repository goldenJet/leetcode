/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 *
 * https://leetcode-cn.com/problems/island-perimeter/description/
 *
 * algorithms
 * Easy (67.54%)
 * Likes:    227
 * Dislikes: 0
 * Total Accepted:    20.9K
 * Total Submissions: 30.9K
 * Testcase Example:  '[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]'
 *
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100
 * 。计算这个岛屿的周长。
 * 
 * 
 * 
 * 示例 :
 * 
 * 输入:
 * [[0,1,0,0],
 * ⁠[1,1,1,0],
 * ⁠[0,1,0,0],
 * ⁠[1,1,0,0]]
 * 
 * 输出: 16
 * 
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        // 原理就是判断1的周围有几个0，有几个0代表有几条边
        int result = 0;
        for (int y = 0; y < grid.length; y++) {
            int[] row = grid[y];
            for (int x = 0; x < row.length; x++) {
                if (row[x] == 0) continue;
                result += islandPerimeterCommon(x, y, grid);
            }
        }
        return result;
    }

    public static int islandPerimeterCommon(int x, int y, int[][] grid) {
        int result = 0;
        int[] row = grid[y];
        // 判断左右
        if (x > 0) result += (row[x-1] == 0 ? 1 : 0);
        if (x < row.length-1) result += (row[x+1] == 0 ? 1 : 0);
        if (x == 0) result += 1;
        if (x == row.length-1) result += 1;
        // 判断上下
        if (y > 0) result += (grid[y-1][x] == 0 ? 1 : 0);
        if (y < grid.length - 1) result += (grid[y+1][x] == 0 ? 1 : 0);
        if (y == 0) result += 1;
        if (y == grid.length - 1) result += 1;
        return result;
    }

}
// @lc code=end

