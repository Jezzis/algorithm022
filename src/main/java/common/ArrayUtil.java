/**
 * Created by szj on 17/4/18.
 */
package common;

public class ArrayUtil {

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static String toString(int[] A) {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < A.length; i++) {
            s.append(String.format("%d, ", A[i]));
        }
        return s.substring(0, s.length() - 2) + "]";
    }

    public static String toString(char[][] A) {
        StringBuilder res = new StringBuilder("[\n");
        for (int i = 0; i < A.length; i++) {
            StringBuilder row = new StringBuilder("[");
            for (int j = 0; j < A[i].length; j++)
                row.append(String.format("%c,", A[i][j]));
            row.substring(0, row.length() - 1);
            res.append(row).append("],\n");
        }
        res.append("]");
        return res.toString();
    }

    public static void print(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.printf("%d,", A[i]);
        }
        System.out.println();
    }

    public static void print(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                System.out.printf("%d,", A[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
