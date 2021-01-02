package practice.loop;

/**
 * Created by szj on 2021/1/2.
 */
public class Sqrt {

    /**
     * 首先随便猜一个近似值x，然后不断令x等于x和a/x的平均数，迭代个六七次后x的值就已经相当精确了
     * @param x
     * @return
     */
    public int sqrt(int x) {
        double tmpx = x;
        double k = 1.0;
        double k0 = 0.0;
        while (Math.abs(k0 - k) >= 1) {
            k0 = k;
            k = (k + tmpx / k) / 2;
        }
        return (int) k;
    }

    public static void main(String[] args) {
        int n = 1024;
        Sqrt sol = new Sqrt();
        System.out.printf("> sqrt(%d) = %d\n", n, sol.sqrt(n));
    }
}
