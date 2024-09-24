/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (
 * representing land) connected 4-directionally (horizontal or vertical.) You may assume
 * all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,
 * 1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,
 * 0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-
 * directionally.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 * <p>
 * <p>
 * Related Topics Array Depth-First Search Breadth-First Search Union Find Matrix
 * 👍 10032 👎 206
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int area = 0;
                    grid[i][j] = 0;
                    Queue<Integer> neiborhoods = new LinkedList<>();
                    neiborhoods.offer(i * cols + j);
                    while (!neiborhoods.isEmpty()) {
                        area++;
                        int id = neiborhoods.poll();
                        int x = id / cols, y = id % cols;
                        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                            grid[x - 1][y] = 0;
                            neiborhoods.offer((x - 1) * cols + y);
                        }
                        if (x + 1 < rows && grid[x + 1][y] == 1) {
                            grid[x + 1][y] = 0;
                            neiborhoods.offer((x + 1) * cols + y);
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                            grid[x][y - 1] = 0;
                            neiborhoods.offer(x * cols + y - 1);
                        }
                        if (y + 1 < cols && grid[x][y + 1] == 1) {
                            grid[x][y + 1] = 0;
                            neiborhoods.offer(x * cols + y + 1);
                        }
                    }
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
