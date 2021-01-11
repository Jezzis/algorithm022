package practice.graph;

public class MinesWeeper {
    public int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    public int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    /**
     * DFS算法
     *  注意drill down 条件:
     *      按照题目规则4, 当该点标记为数字时, 没必要继续规约
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M')
            board[x][y] = 'X';
        else
            dfs(board, x, y);
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        int cnt = 0;
        // 雷计数: 相邻八个位置探索
        for (int i = 0; i < 8; ++i) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) continue; // 超边界
            // 不用判断 M，因为如果有 M 的话游戏已经结束了
            if (board[tx][ty] == 'M') {
                ++cnt;
            }
        }

        // 标记
        if (cnt > 0) {
            board[x][y] = (char) (cnt + '0');
            return ;
        }

        // drill down
        board[x][y] = 'B';
        for (int i = 0; i < 8; ++i) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E')
                continue;
            dfs(board, tx, ty);
        }
    }
}