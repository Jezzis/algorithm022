package practice.recursion;

import common.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return all possible subsets (the power set).

 The solution set must not contain duplicate subsets.

 Example 1:

 Input: nums = [1,2,3]
 Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 Example 2:

 Input: nums = [0]
 Output: [[],[0]]
  

 Constraints:

 1 <= nums.length <= 10
 -10 <= nums[i] <= 10
 All the numbers of nums are unique.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/subsets
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubSets {

    private List<List<Integer>> res;

    /**
     * 利用二进制位 将 2^n个结果 依次展开，循环loop获得结果
     * @param nums
     * @return
     */
    public List<List<Integer>> loop(int[] nums) {
        int total = 1 << nums.length;
        res = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> (nums.length - j - 1)) & 1) != 0) row.add(nums[j]);
            res.add(row);
        }
        return res;
    }

    public List<List<Integer>> loop2(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int n : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : res) {
                subset.add(n);
                newSubsets.add(new ArrayList<>(subset));
                subset.remove(subset.size() - 1);
            }
            res.addAll(newSubsets);
        }
        return res;
    }

    /**
     * 经典分治法，分解为子问题: 在每一位上分别考虑保留/舍弃
     * @param nums
     * @return
     */
    public List<List<Integer>> s1(int[] nums) {
        res = new ArrayList<>();
        recursion(nums, 0, new ArrayList<>());
        return res;
    }

    public void recursion(int[] nums, int pos, List<Integer> row) {
        if (pos >= nums.length) {
            res.add(new ArrayList<>(row));
            return;
        }

        recursion(nums, pos + 1, row);
        row.add(nums[pos]);
        recursion(nums, pos + 1, row);

        row.remove(row.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        SubSets sol = new SubSets();
        List<List<Integer>> res = sol.loop(arr);
        List<List<Integer>> res1 = sol.s1(arr);
        System.out.printf("> Input: %s\n", ArrayUtil.toString(arr));
        System.out.printf("> Output: \nloop=%s\nrecursion=%s\n", res.toString(), res1.toString());
    }
}
