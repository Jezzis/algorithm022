/**
 * Created by szj on 2020/12/22.
 */
package practice.list;
import common.ListNode;
import common.ArrayUtil;

public class MergeTwoLists {

    /**
     * 递归实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode recursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = recursive(l1.next, l2);
            return l1;
        }

        l2.next = recursive(l1, l2.next);
        return l2;
    }

    /**
     * 非递归实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode norecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }

    public static void test() {
        int[] a = new int[]{1,3,5,7,9};
        int[] b = new int[]{2,4,6,8,10};
        ListNode l1 = ListNode.build(a);
        ListNode l2 = ListNode.build(b);
        System.out.printf("> Input: %s, %s\n", ArrayUtil.toString(a), ArrayUtil.toString(b));
        MergeTwoLists s = new MergeTwoLists();
        ListNode r = s.norecursive(l1, l2);
        System.out.printf("> Output: \n");
        ListNode.print(r);
    }

    public static void main(String[] args) {
        test();
    }
}
