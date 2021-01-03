package practice.recursion;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 Note:
 You may assume that duplicates do not exist in the tree.

 For example, given

 preorder = [3,9,20,15,7]
 inorder = [9,3,15,20,7]
 Return the following binary tree:

 3
 / \
 9  20
 /  \
 15   7


 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * 迭代:先序第一位为根, 映射找到中序根位置, 在中序中确定左右子树长度
     * @param preorder
     * @param inorder
     * @param preStart
     * @param preEnd
     * @param inStart
     * @param inEnd
     * @return
     */
    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        // pre order | -> root <- | -> left <- | -> right <- |
        // in  order | -> left <- | -> root <- | -> right <- |
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(preorder[preStart]), leftLen = inRoot - inStart;
        root.left = build(preorder, inorder, preStart + 1, preStart + leftLen, inStart, inRoot - 1);
        root.right = build(preorder, inorder, preStart + leftLen + 1, preEnd, inRoot + 1, inEnd);

        return root;
    }
}
