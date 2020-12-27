package practice.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.

  

 Example 1:


 Input: root = [1,null,2,3]
 Output: [1,2,3]
 Example 2:

 Input: root = []
 Output: []
 Example 3:

 Input: root = [1]
 Output: [1]
 Example 4:


 Input: root = [1,2]
 Output: [1,2]
 Example 5:


 Input: root = [1,null,2]
 Output: [1,2]
  

 Constraints:

 The number of nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100
  

 Follow up:

 Recursive solution is trivial, could you do it iteratively?



 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePreorderTraversal {

    private List<Integer> res;

    public List<Integer> preorderTraversal(TreeNode root) {
        return recursive(root);
    }

    public List<Integer> recursive(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    public List<Integer> loopTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            if (n == null) continue;
            res.add(n.val);
            s.push(n.right);
            s.push(n.left);
        }
        return res;
    }

    public void dfs(TreeNode n) {
        if (n == null) return ;
        res.add(n.val);
        dfs(n.left);
        dfs(n.right);
    }
}
