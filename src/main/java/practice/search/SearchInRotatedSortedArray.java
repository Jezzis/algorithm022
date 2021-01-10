package practice.search;

public class SearchInRotatedSortedArray {

    /**
     * 二分查找 O(log N)
     *
     * 原来的二分逻辑由于数组是递增的，只需要判定mid就可以确定二分段(规约);<br/>
     *   该题有点巧妙，虽然场景上数组不是严格递增的，但却是部分递增, 依然可以二分，只是判定的逻辑多一层:
     *   - 1) 判定哪边是单调的 (left < right 肯定单调)
     *   - 2) 判定target是否在单调那一边 (在单调段, 设边界为left, right; 必有 left < target < right)
     *
     *   这两层逻辑我们通过边界: left, mid, right这三个值可以判定出来，从而可以二分
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // System.out.printf("> %d - %d\n", left, right);
            int mid = left + ((right - left) / 2);
            if (nums[mid] == target) return mid;
            if (nums[left] < nums[mid] && target >= nums[left] && target <= nums[mid]) { // 左段单调 && target在其中
                right = mid - 1;
            } else if (nums[mid] < nums[right] && (target < nums[mid] || target > nums[right])) { // 右段单调 && target不在其中
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            // System.out.printf("%d - %d\n", left, right);
        }
        return -1;
    }
}
