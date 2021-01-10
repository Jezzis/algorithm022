package practice.greedy;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobot {

    public int N = 30000;

    /**
     * 原逻辑改位运算: < 92%, 泣血!!
     * 再改逻辑判断上下左右位移为数组计算: < 97%, 再次泣血!!
     * 再改HashSet init size = obstacles.length / 0.75 + 1: < 99%, 再次泣血!!
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1}, dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0, d = 0;
        Set<Integer> obstaclesSet = new HashSet<>((int) (obstacles.length / 0.75) + 1);
        for (int i = 0; i < obstacles.length; i++)
            obstaclesSet.add(mask(obstacles[i][0], obstacles[i][1]));

        int res = -1;
        for (int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
                continue;
            } else if (c == -2) {
                d = (d + 3) % 4;
                continue;
            }

            int step = c, nx, ny;
            while (step > 0) {
                nx = x + dx[d];
                ny = y + dy[d];

                // System.out.printf("detect %d, %d\n", nx, ny);
                if (obstaclesSet.contains(mask(nx, ny))) break;
                x = nx;
                y = ny;
                step --;
            }
            // System.out.printf("command = %d, -> %d, %d\n", c, x, y);
            res = Math.max(res, x * x + y * y);
        }
        return res;
    }

    private int mask(int x, int y) {
        return ((x + N) << 16) | (y + N);
    }

    /**
     * 手写ac算法, 不使用位运算 < 6%
     * @param commands
     * @param obstacles
     * @return
     */
    public int raw(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, d = 0;
        Set<String> obstaclesSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++)
            obstaclesSet.add(String.format("%d-%d", obstacles[i][0], obstacles[i][1]));
        // System.out.printf("%d, %d\n", obstacles[i][0], obstacles[i][1]);

        int res = -1;
        for (int c : commands) {
            if (c == -1) {
                d = (d + 1) % 4;
                continue;
            } else if (c == -2) {
                d = (d + 3) % 4;
                continue;
            }

            int step = c, nx, ny;
            while (step > 0) {
                nx = x;
                ny = y;
                if (d == 0) { // 上
                    ny = y + 1;
                } else if (d == 1) { // 右
                    nx = x + 1;
                } else if (d == 2) { // 下
                    ny = y - 1;
                } else { // 左
                    nx = x - 1;
                }

                // System.out.printf("detect %d, %d\n", nx, ny);
                if (obstaclesSet.contains(String.format("%d-%d", nx, ny))) break;
                x = nx;
                y = ny;
                step --;
            }
            // System.out.printf("command = %d, -> %d, %d\n", c, x, y);
            res = Math.max(res, x * x + y * y);
        }
        return res;
    }
}
