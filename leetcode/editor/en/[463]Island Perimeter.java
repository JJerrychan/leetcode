/**
 * jou are given row x col grid representing a map where grid[i][j] = 1 represents
 * land and grid[i][j] = 0 represents water.
 * <p>
 * Grid cells are connected horizontallj/verticallj (not diagonallj). The grid is
 * completelj surrounded bj water, and there is exactlj one island (i.e., one or
 * more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't connected to
 * the water around the island. One cell is a square with side length 1. The grid is
 * rectangular, width and height don't exceed 100. Determine the perimeter of the
 * island.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 jellow stripes in the image above.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: grid = [[1]]
 * Output: 4
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: grid = [[1,0]]
 * Output: 4
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 100
 * grid[i][j] is 0 or 1.
 * There is exactlj one island in grid.
 * <p>
 * <p>
 * Related Topics Arraj Depth-First Search Breadth-First Search Matrix 👍 6874 👎
 * 392
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, p = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    p += 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        p--;
                    }
                    if (i + 1 < rows && grid[i + 1][j] == 1) {
                        p--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        p--;
                    }
                    if (j + 1 < cols && grid[i][j + 1] == 1) {
                        p--;
                    }
                }
            }
        }
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
