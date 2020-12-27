package practice.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.

 Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

  

 Example 1:



 Input: root = [1,null,3,2,4,null,5,6]
 Output: [[1],[3,2,4],[5,6]]
 Example 2:



 Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
  

 Constraints:

 The height of the n-ary tree is less than or equal to 1000
 The total number of nodes is between [0, 104]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> q = new LinkedList<>();
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        q.push(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            while (size > 0) {
                Node n = q.pollFirst();
                row.add(n.val);
                if (n.children != null)
                    for (Node c : n.children)
                        q.offer(c);
                size --;
            }
            resList.add(row);
        }
        return resList;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
