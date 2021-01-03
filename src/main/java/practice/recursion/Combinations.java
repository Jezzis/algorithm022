package practice.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * You may return the answer in any order.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * Example 2:
 * <p>
 * Input: n = 1, k = 1
 * Output: [[1]]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combinations {

    // 注意剪枝
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs(1, k, n, res, resList);
        return resList;
    }

    public void dfs(int pos, int k, int n, List<Integer> res, List<List<Integer>> resList) {
        if (res.size() == k) {
            resList.add(new ArrayList<>(res));
            return;
        }
        if (pos > n) return;

        // drill down
        res.add(pos);
        dfs(pos + 1, k, n, res, resList); // remain

        res.remove(res.size() - 1);
        if (k - res.size() <= n - pos) // 剪枝
            dfs(pos + 1, k, n, res, resList); // drop
    }
}
