package practice.search;

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
