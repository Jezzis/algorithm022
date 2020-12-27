/**
 * Created by szj on 2020/12/22.
 */
package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        System.out.printf("%d", this.val);
    }

    public static void print(ListNode n) {
        ListNode c = n;
        while (c != null) {
            System.out.printf("-> %d ", c.val);
            c = c.next;
        }
        System.out.println();
    }

    public static ListNode build(int[] a) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        for (int i : a) {
            ListNode n = new ListNode(i);
            dummy.next = n;
            dummy = n;
        }
        return pre.next;
    }
}
