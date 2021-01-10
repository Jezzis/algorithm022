package practice.greedy;

import java.util.Arrays;

public class FindContentChildren {

    /**
     * 贪婪算法: 优秀答案
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (null == g || null == s || g.length == 0 || s.length == 0)
            return 0;

        Arrays.sort(g);
        Arrays.sort(s);
        int i, j;
        for (i = 0, j = 0; i < g.length && j < s.length; j++)
            if (g[i] <= s[j])
                i++;
        return i;
    }

    /**
     * 贪婪算法: 练习实现
     * @param g
     * @param s
     * @return
     */
    public int s1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; i++) {
            while (j < s.length && g[i] > s[j]) j++;
            if (j < s.length && g[i] <= s[j]) {
                j++;
                res++;
            }
        }
        return res;
    }
}
