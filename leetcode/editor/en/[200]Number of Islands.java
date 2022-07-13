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
class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        Queue<Node> queue = new LinkedList<Node>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    queue.offer(new Node(i, j));
                }
                while (!queue.isEmpty()) {
                    Node curr = queue.poll();
                    grid[curr.x][curr.y] = '0';
                    if (curr.x - 1 >= 0 && grid[curr.x - 1][curr.y] == '1') {
                        queue.offer(new Node(curr.x - 1, curr.y));
                        grid[curr.x - 1][curr.y] = '0';
                    }
                    if (curr.y - 1 >= 0 && grid[curr.x][curr.y - 1] == '1') {
                        queue.offer(new Node(curr.x, curr.y - 1));
                        grid[curr.x][curr.y - 1] = '0';
                    }
                    if (curr.x + 1 < row && grid[curr.x + 1][curr.y] == '1') {
                        queue.offer(new Node(curr.x + 1, curr.y));
                        grid[curr.x + 1][curr.y] = '0';
                    }
                    if (curr.y + 1 < col && grid[curr.x][curr.y + 1] == '1') {
                        queue.offer(new Node(curr.x, curr.y + 1));
                        grid[curr.x][curr.y + 1] = '0';
                    }
                }
            }
        }
        return islands;
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
