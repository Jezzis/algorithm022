package practice.graph;

import common.ArrayUtil;

/**
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *  
 *
 * Example 1:
 *
 * Input:
 *
 * [['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'M', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E'],
 *  ['E', 'E', 'E', 'E', 'E']]
 *
 * Click : [3,0]
 *
 * Output:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Explanation:
 *
 * Example 2:
 *
 * Input:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'M', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Click : [1,2]
 *
 * Output:
 *
 * [['B', '1', 'E', '1', 'B'],
 *  ['B', '1', 'X', '1', 'B'],
 *  ['B', '1', '1', '1', 'B'],
 *  ['B', 'B', 'B', 'B', 'B']]
 *
 * Explanation:
 *
 *  
 *
 * Note:
 *
 * The range of the input matrix's height and width is [1,50].
 * The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
 * The input board won't be a stage when game is over (some mines have been revealed).
 * For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minesweeper
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinesWeeper {
    public int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    public int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    /**
     * DFS算法
     *  注意drill down 条件:
     *      按照题目规则4, 当该点标记为数字时, 没必要继续递归
     *      当标记为B时，继续递归
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        dfs(board, x, y);
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        if (!valid(board, x, y) || board[x][y] != 'E') return;
        int cnt = 0; // Mines counter
        for (int i = 0; i < 8; i++) {
            int nx = x + dirX[i], ny = y + dirY[i];
            if (valid(board, nx, ny) && board[nx][ny] == 'M') cnt++;
        }

        if (cnt > 0)
            board[x][y] = (char) ('0' + cnt);
        else
            board[x][y] = 'B';
        for (int i = 0; i < 8; i++) {
            int nx = x + dirX[i], ny = y + dirY[i];
            dfs(board, nx, ny);
        }
    }

    public boolean valid(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length)
            return false;
        return true;
    }

    public static void main(String[] args) {
        char[][] map = new char[][]{
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'M', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
            {'E', 'E', 'E', 'E', 'E'},
        };

        int[] click = new int[]{3, 0};
        System.out.printf("> Input: map: %s, click: %s\n", ArrayUtil.toString(map), ArrayUtil.toString(click));
        MinesWeeper sol = new MinesWeeper();
        sol.updateBoard(map, click);

        System.out.printf("\n> Output: map: %s", ArrayUtil.toString(map));
    }
}