package practice.search;

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums, return the minimum element of this array.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
 * Example 3:
 *
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 *  
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchMinInRotatedSortedArray {

    /**
     * 二分查找 O(log N)
     *
     * 原来的二分逻辑由于数组是递增的，只需要判定mid就可以确定二分段(规约);<br/>
     *   该题有点巧妙，虽然场景上数组不是严格递增的，但却是部分递增, 依然可以二分，只是判定的逻辑改变下:
     *   - 判定哪边是非单调的 (left < right 肯定单调)
     *   - 若正好mid > mid + 1, 则mid + 1为最小值
     *
     *   若未找到，则序列是严格单调递增的
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // System.out.printf("> %d - %d\n", left, right);
            int mid = left + ((right - left) / 2);
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else if (nums[left] > nums[mid]) // 左段非单调
                right = mid;
            else
                left = mid + 1;
        }
        return nums[0];
    }
}
