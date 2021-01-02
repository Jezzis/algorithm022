package practice.recursion;

import java.util.*;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

 * Example 1:
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 *
 * Example 2:
 * Input: n = 1
 * Output: [["Q"]]
 *  
 * Constraints:

 * 1 <= n <= 9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-queens
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NQueues {

    private Set<Integer> cols;
    private Set<Integer> pie;
    private Set<Integer> na;
    private List<List<String>> resList;


    public List<List<String>> s2(int n) {
        resList = new ArrayList<>();
        if (n == 0) return resList;

        int col = 0;
        int main = 0;
        int sub = 0;
        Deque<Integer> path = new ArrayDeque<>();

        dfs(n, 0, col, main, sub, path);
        return resList;
    }

    private void dfs(int n, int row, int col, int sub, int main, Deque<Integer> path) {
        if (row == n) {
            List<String> board = convert2board(n, path);
            resList.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0
                    && ((main >> (row - i + n - 1)) & 1) == 0
                    && ((sub >> (row + i)) & 1) == 0) {
                path.addLast(i);
                col ^= (1 << i);
                main ^= (1 << (row - i + n - 1));
                sub ^= (1 << (row + i));

                dfs(n, row + 1, col, sub, main, path);

                sub ^= (1 << (row + i));
                main ^= (1 << (row - i + n - 1));
                col ^= (1 << i);
                path.removeLast();
            }
        }
    }

    private List<String> convert2board(int n, Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < Math.max(0, n); i++)
                row.append('.');
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }

    public List<List<String>> s1(int n) {
        cols = new HashSet<>();
        pie = new HashSet<>();
        na = new HashSet<>();
        resList = new ArrayList<>();

        List<Integer> validCols = new ArrayList<>();
        DFS(0, n, validCols);
        return resList;
    }

    public void DFS(int row, int n, List<Integer> rs) {
        if (row >= n) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder s = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (rs.get(i).equals(j)) s.append('Q');
                    else s.append('.');
                }
                res.add(s.toString());
            }
            resList.add(res);
//            System.out.printf("rows: %s, cols: %s, rs: %s\n", rows, cols, rs);
            return ;
        }

        for (int col = 0; col < n; col++) {

            if (cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) continue;

            cols.add(col);
            pie.add(row + col);
            na.add(row - col);

            rs.add(col);
            DFS(row + 1, n, rs);
            rs.remove(rs.size() - 1);

            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        NQueues q = new NQueues();
        List<List<String>> res = q.s2(n);
        System.out.printf("> Input: %d\n", n);
        System.out.printf("> Output: %s\n", res);
    }

}
