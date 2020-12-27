package practice.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 编写一个程序，找出第 n 个丑数。

 丑数就是质因数只包含 2, 3, 5 的正整数。

 示例:

 输入: n = 10
 输出: 12
 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 说明:  

 1 是丑数。
 n 不超过1690。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/ugly-number-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UglyNumber2 {

    private static int[] cache;

    static {
        heap();
    }

    /**
     * 用最小堆, 时间复杂度O(1), 空间复杂度O(1)
     */
    public static void heap() {
        int n = 1690;
        cache = new int[n];
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        set.add(1L);
        queue.add(1L);

        int[] primes = new int[]{2,3,5};
        for (int i = 0; i < n; i++) {
            long min = queue.poll();
            cache[i] = (int) min;
            for (int prime : primes) {
                long u = min * prime;
                if (!set.contains(u)) {
                    queue.offer(u);
                    set.add(u);
                }
            }
        }
    }

    /**
     * 用动态规划, 三指针
     */
    public static void dynamic() {
        int n = 1690;
        cache = new int[n];

        int i2 = 0, i3 = 0, i5 = 0;
        cache[0] = 1;

        for (int i = 1; i < n; i++) {
            int ugly = Math.min(Math.min(cache[i2] * 2, cache[i3] * 3), cache[i5] * 5);
            cache[i] = ugly;

            if (ugly == cache[i2] * 2) i2++;
            if (ugly == cache[i3] * 3) i3++;
            if (ugly == cache[i5] * 5) i5++;
        }
    }

    public int nthUglyNumber(int n) {
        return UglyNumber2.cache[n - 1];
    }
}
