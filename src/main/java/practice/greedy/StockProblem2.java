package practice.greedy;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StockProblem2 {

    /**
     * 贪心算法: 该问题限制同时最多持有一只股票, 不限制交易次数，正好符合贪心算法的应用场景
     * @param prices
     * @return
     */
    public int greedy(int[] prices) {
        int profits = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1]) profits += prices[i] - prices[i - 1];
        return profits;
    }

    /**
     * 经典动态规划, 这类题还有4种变形，分别限制买入数，交易次数，交易间隔时间等
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i - 1], dp[i - 1][0]); // 不持有 = max(昨天不持有, 昨天持有今天卖掉)
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i - 1], dp[i - 1][1]); // 持有 = max(昨天持有, 昨天不持有今天买入)
            // System.out.printf("dp[%d][0]=%d, dp[%d][1]=%d\n", i, dp[i][0], i, dp[i][1]);
        }
        return Math.max(dp[prices.length][0], dp[prices.length][1]);
    }
}
