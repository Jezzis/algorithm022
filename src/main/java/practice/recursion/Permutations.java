package practice.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 Example 1:

 Input: nums = [1,2,3]
 Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 Example 2:

 Input: nums = [0,1]
 Output: [[0,1],[1,0]]
 Example 3:

 Input: nums = [1]
 Output: [[1]]
  
 Constraints:

 1 <= nums.length <= 6
 -10 <= nums[i] <= 10
 All the integers of nums are unique.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutations
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {

    public List<List<Integer>> s2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        int len = nums.length;
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1, path, used, res); // drill down
                used[i] = false; // reverse
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> s1(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dfs1(nums, res, resList);
        return resList;
    }

    public void dfs1(int[] nums, List<Integer> res, List<List<Integer>> resList) {
        // terminator
        if (res.size() == nums.length) {
            resList.add(new ArrayList<>(res));
            return ;
        }


        for (int i = 0; i < nums.length; i++)
            if (!res.contains(nums[i])) {
                res.add(nums[i]);
                dfs1(nums, res, resList); // drill down
                res.remove(res.size() - 1); // reverse
            }
    }
}
