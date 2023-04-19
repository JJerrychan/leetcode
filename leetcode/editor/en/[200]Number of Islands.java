//Given an m x n 2D binary grid grid which represents a map of '1's (land) and 
//'0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 14798 👎 348


import java.util.LinkedList;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
//DFS
/*class Solution {
    void dfs(char[][] grid, int x, int y) {
        int rows = grid.length, cols = grid[0].length;
        if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, nums = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    nums++;
                }
            }
        }
        return nums;
    }
}*/
//BFS
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, nums = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    grid[i][j] = '0';
                    Queue<Integer> neiborhoods = new LinkedList<>();
                    neiborhoods.offer(i * cols + j);
                    while (!neiborhoods.isEmpty()) {
                        int id = neiborhoods.poll();
                        int x = id / cols, y = id % cols;
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            neiborhoods.offer((x - 1) * cols + y);
                        }
                        if (x + 1 < rows && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            neiborhoods.offer((x + 1) * cols + y);
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            neiborhoods.offer(x * cols + y - 1);
                        }
                        if (y + 1 < cols && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            neiborhoods.offer(x * cols + y + 1);
                        }
                    }
                }
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
