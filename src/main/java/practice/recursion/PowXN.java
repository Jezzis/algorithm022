package practice.recursion;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e. xn).

 Example 1:

 Input: x = 2.00000, n = 10
 Output: 1024.00000
 Example 2:

 Input: x = 2.10000, n = 3
 Output: 9.26100
 Example 3:

 Input: x = 2.00000, n = -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25
  

 Constraints:

 -100.0 < x < 100.0
 -231 <= n <= 231-1
 -104 <= xn <= 104


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/powx-n
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PowXN {

    public double loop(double x, int n) {
        double res = 1.0;
        for (int c = n; c != 0; c /= 2) {
            if (c % 2 != 0) res *= x;
            x *= x;
        }
        return n > 0 ? res : 1.0 / res;
    }

    public double recursion(double x, int n) {
        return n >= 0 ? fastPow(x, n) : 1.0 / fastPow(x, n);
    }

    public double fastPow(double x, int n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        if (Math.abs(n % 2) == 1) return x * half * half;
        return half * half;
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = -5;
        System.out.printf("> Input: x=%f, n=%d\n", x, n);
        PowXN pow = new PowXN();
        double res = pow.loop(x, n);
        double res1 = pow.recursion(x, n);
        System.out.printf("> Output: res=%f, res1=%f\n", res, res1);
    }
}
