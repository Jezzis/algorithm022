package practice.greedy;

import common.ArrayUtil;
import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *  
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 * Example 4:
 *
 * Input: coins = [1], amount = 1
 * Output: 1
 * Example 5:
 *
 * Input: coins = [1], amount = 2
 * Output: 2
 *  
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange {

    /**
     * 带回溯
     * N = amount, K = coins.length
     * 在DFS基础上，采用贪心策略，加上剪枝，时间复杂度都是O(K x N)，收敛的更快
     * @param coins
     * @param amount
     * @return
     */
    public int greedy(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);

        int ans = Integer.MAX_VALUE;
        ans = recur(coins, amount, 0, 0, ans);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int recur(int[] coins, int amount, int i, int c, int ans) {
//        System.out.printf("recur: amount=%d, i=%d, c=%d, ans=%d\n", amount, i, c, ans);
        // terminator
        if (amount == 0) return Math.min(ans, c);
        if (i == coins.length) return ans;
        for (int k = amount / coins[coins.length - i - 1]; k >= 0 && k + c < ans; k--) { // k + c < ans 限制条件进行剪枝
            // drill down: 先从面值大的零钱开始兑换(贪婪)
            ans = recur(coins, amount - k * coins[coins.length - i - 1], i + 1, c + k, ans);
        }
        return ans;
    }

    /**
     * 动态规划算法, 算法效率不高, 设 K = coins.length, N = amount, 时间复杂度为 O(K*N)
     * @param coins
     * @param amount
     * @return
     */
    public int dp(int[] coins, int amount) {
        if (amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i <= amount; i++) {
            if (i == 0) dp[0] = 0;
            for (int c : coins) {
                if (c <= i && dp[i - c] >= 0)
                    dp[i] = dp[i] > 0 ? Math.min(dp[i - c] + 1, dp[i]) : dp[i - c] + 1;
            }
            // System.out.printf("dp[%d]=%d\n", i, dp[i]);
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int res, amount = 11;
        System.out.printf("> Input: coins: %s, amount: %d\n", ArrayUtil.toString(coins), amount);
        CoinChange sol = new CoinChange();
        res = sol.greedy(coins, amount);
        System.out.printf("> Output: %d\n", res);
    }
}
