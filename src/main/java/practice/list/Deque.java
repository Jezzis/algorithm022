package practice.list;

/**
 * Created by szj on 2020/12/29.
 */
public class Deque<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int size() {
        return size;
    }

    public Deque() {
    }

    public T pollFirst() throws Exception {
        if (head == null) throw new Exception("empty queue");
        Node<T> n = head;
        if (head.next != null)
            head.next.prev = null;
        head = head.next;
        size--;
        return n.val;
    }

    public T pollLast() throws Exception {
        if (tail == null) throw new Exception("empty queue");
        Node<T> n = tail;
        if (tail.prev != null)
            tail.prev.next = null;
        tail = tail.prev;
        size--;
        return n.val;
    }

    public T pop() throws Exception {
        return pollLast();
    }

    public void addLast(T v) {
        Node<T> n = new Node<T>(v);
        size++;
        if (head == null || tail == null) {
            head = n;
            tail = n;
            return;
        }

        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    public void addFirst(T v) {
        Node<T> n = new Node<>(v);
        size++;
        if (head == null || tail == null) {
            head = n;
            tail = n;
            return;
        }
        n.next = head;
        head.prev = n;
        head = n;
    }

    public void add(T n) {
        addLast(n);
    }

    /**
     * 按索引插入
     * -> prev -> cur -> next
     * |-> n  ->|
     *
     * @param index
     * @param v
     * @throws Exception
     */
    public void add(int index, T v) throws Exception {
        Node<T> n = new Node<>(v);
        if (index >= size) throw new Exception("invalid index");
        Node<T> cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        if (cur.prev != null) {
            cur.prev.next = n;
            n.prev = cur.prev;
        } else {
            head = n;
        }
        n.next = cur;
        cur.prev = n;
        size++;
    }

    /**
     * 按索引删除
     * -> prev -> cur -> next ->
     * |->     ->   ->|
     *
     * @param index
     * @throws Exception
     */
    public void remove(int index) throws Exception {
        if (index >= size) throw new Exception("invalid index");
        Node<T> cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        if (cur.prev != null)
            cur.prev.next = cur.next;
        else
            head = cur.next;
        if (cur.next == null)
            tail = cur.prev;
        size--;
    }

    public void offer(T v) {
        addLast(v);
    }

    public void print() {
        System.out.printf("size: %d, ", size);
        Node<T> cur = head;
        while (cur != null) {
            System.out.printf("-> %s ", cur.val);
            cur = cur.next;
        }
        System.out.println();
    }

    class Node<T> {
        public Node<T> next;
        public Node<T> prev;
        public T val;

        public Node(T v) {
            val = v;
        }

        public Node(T v, Node<T> next, Node<T> prev) {
            this.val = v;
            this.prev = prev;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> q = new Deque<>();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        for (int i : arr)
            q.add(i);
        q.print();

        try {
            q.add(0, -1);
            q.print();

            q.pollFirst();
            q.print();

            q.add(9, -1);
            q.print();

            q.pollLast();
            q.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
