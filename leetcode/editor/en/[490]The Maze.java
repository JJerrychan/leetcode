//There is a ball in a maze with empty spaces (represented as 0) and walls (
//represented as 1). The ball can go through the empty spaces by rolling up, down, 
//left or right, but it won't stop rolling until hitting a wall. When the ball stops,
// it could choose the next direction. 
//
// Given the m x n maze, the ball's start position and the destination, where 
//start = [startrow, startcol] and destination = [destinationrow, destinationcol], 
//return true if the ball can stop at the destination, otherwise return false. 
//
// You may assume that the borders of the maze are all walls (see examples). 
//
// 
// Example 1: 
// 
// 
//Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], 
//start = [0,4], destination = [4,4]
//Output: true
//Explanation: One possible way is : left -> down -> left -> down -> right -> 
//down -> right.
// 
//
// Example 2: 
// 
// 
//Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], 
//start = [0,4], destination = [3,2]
//Output: false
//Explanation: There is no way for the ball to stop at the destination. Notice 
//that you can pass through the destination but you cannot stop there.
// 
//
// Example 3: 
//
// 
//Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], 
//start = [4,3], destination = [0,1]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == maze.length 
// n == maze[i].length 
// 1 <= m, n <= 100 
// maze[i][j] is 0 or 1. 
// start.length == 2 
// destination.length == 2 
// 0 <= startrow, destinationrow <= m 
// 0 <= startcol, destinationcol <= n 
// Both the ball and the destination exist in an empty space, and they will not 
//be in the same position initially. 
// The maze contains at least 2 empty spaces. 
// 
//
// Related Topics Depth-First Search Breadth-First Search Graph 👍 1646 👎 169


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean dfs(int[][] maze, int x, int y, int[] destination, boolean[][] visited) {
        if (visited[x][y]) return false;
        int rows = maze.length, cols = maze[0].length;
        if (x == destination[0] && y == destination[1]) return true;
        visited[x][y] = true;
        int up = x - 1, down = x + 1, left = y - 1, right = y + 1;
        while (up >= 0 && maze[up][y] == 0) up--;
        if (dfs(maze, up+1, y, destination, visited)) return true;
        while (down < rows && maze[down][y] == 0) down++;
        if (dfs(maze, down-1, y, destination, visited)) return true;
        while (left >= 0 && maze[x][left] == 0) left--;
        if (dfs(maze, x, left+1, destination, visited)) return true;
        while (right < cols && maze[x][right] == 0) right++;
        if (dfs(maze, x, right-1, destination, visited)) return true;
        return false;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        return dfs(maze, start[0], start[1], destination, new boolean[maze.length][maze[0].length]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
