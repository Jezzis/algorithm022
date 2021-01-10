package practice.greedy;

/**
 * At a lemonade stand, each lemonade costs $5. 
 *
 * Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
 *
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
 *
 * Note that you don't have any change in hand at first.
 *
 * Return true if and only if you can provide every customer with correct change.
 *
 *  
 *
 * Example 1:
 *
 * Input: [5,5,5,10,20]
 * Output: true
 * Explanation:
 * From the first 3 customers, we collect three $5 bills in order.
 * From the fourth customer, we collect a $10 bill and give back a $5.
 * From the fifth customer, we give a $10 bill and a $5 bill.
 * Since all customers got correct change, we output true.
 * Example 2:
 *
 * Input: [5,5,10]
 * Output: true
 * Example 3:
 *
 * Input: [10,10]
 * Output: false
 * Example 4:
 *
 * Input: [5,5,10,10,20]
 * Output: false
 * Explanation:
 * From the first two customers in order, we collect two $5 bills.
 * For the next two customers in order, we collect a $10 bill and give back a $5 bill.
 * For the last customer, we can't give change of $15 back because we only have two $10 bills.
 * Since not every customer received correct change, the answer is false.
 *  
 *
 * Note:
 *
 * 0 <= bills.length <= 10000
 * bills[i] will be either 5, 10, or 20.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LemonadeChange {

    /**
     * 贪婪算法: 时间复杂度O(N)
     *  正好账单是5的倍数，能够证明贪婪算法是全局最优解
     *  Tips: Java这里不要用数组保存各面值零钱数，直接用变量
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int fiveChange = 0, tenChange = 0; // $5, $10, $20
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) fiveChange ++;
            else if (bills[i] == 10) {
                fiveChange--;
                tenChange++;
            } else {
                if (tenChange > 0) {
                    tenChange--;
                    fiveChange--;
                } else {
                    fiveChange -= 3;
                }
            }
            if (fiveChange < 0) return false;
        }
        return true;
    }
}
