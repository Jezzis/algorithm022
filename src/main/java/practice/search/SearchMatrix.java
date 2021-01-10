package practice.search;

public class SearchMatrix {
    /**
     * 左下角开始，类似二分，上面的元素都较小，右边的元素都较大
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int N = matrix.length, M = matrix[0].length;
        int x = N - 1, y = 0;
        while (x < N && x >= 0 && y < M && y >= 0) {
            // System.out.printf("> search %d, %d\n", x, y);
            if (target == matrix[x][y]) return true;
            else if (target < matrix[x][y]) x--;
            else y++;
        }
        return false;
    }
}
