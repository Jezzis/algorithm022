package practice.recursion;

public class NumberOfIslands {
    /**
     * DFS算法: 有一个技巧，每次遇到'1'，则dfs遍历级联位置重置'0'，同时计数+1;
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
        return numIslands;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0')
            return;
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
