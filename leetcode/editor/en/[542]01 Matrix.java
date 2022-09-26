//Given an m x n binary matrix mat, return the distance of the nearest 0 for 
//each cell. 
//
// The distance between two adjacent cells is 1. 
//
// 
// Example 1: 
// 
// 
//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//Output: [[0,0,0],[0,1,0],[0,0,0]]
// 
//
// Example 2: 
// 
// 
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//Output: [[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// There is at least one 0 in mat. 
// 
//
// Related Topics Array Dynamic Programming Breadth-First Search Matrix 👍 5691 
//👎 286


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int INF = mat.length + mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) continue;
                int top = (i - 1 >= 0) ? mat[i - 1][j] : INF;
                int left = (j - 1 >= 0) ? mat[i][j - 1] : INF;
                int dist = Math.min(top, left);
                mat[i][j] = dist + 1;
            }
        }
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 0) continue;
                int down = (i + 1 < mat.length) ? mat[i + 1][j] : INF;
                int right = (j + 1 < mat[0].length) ? mat[i][j + 1] : INF;
                int dist = Math.min(down, right);
                mat[i][j] = Math.min(mat[i][j], dist + 1);
            }
        }
        return mat;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
