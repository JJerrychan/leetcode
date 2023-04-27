//Given an m x n grid of characters board and a string word, return true if 
//word exists in the grid. 
//
// The word can be constructed from letters of sequentially adjacent cells, 
//where adjacent cells are horizontally or vertically neighboring. The same letter 
//cell may not be used more than once. 
//
// 
// Example 1: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
//Output: true
// 
//
// Example 3: 
// 
// 
//Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board and word consists of only lowercase and uppercase English letters. 
// 
//
// 
// Follow up: Could you use search pruning to make your solution faster with a 
//larger board? 
//
// Related Topics Array Backtracking Matrix 👍 13173 👎 536


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }

        if (x >= board.length || x < 0 || y >= board[x].length || y < 0 || board[x][y] != word.charAt(index) || visited[x][y]) {
            return false;
        }

        visited[x][y] = true;
        if (search(board, word, x - 1, y, index + 1) || search(board, word, x + 1, y, index + 1) || search(board, word, x, y - 1, index + 1) || search(board, word, x, y + 1, index + 1)) {
            return true;
        }

        visited[x][y] = false;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
