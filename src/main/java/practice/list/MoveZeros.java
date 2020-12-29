package practice.list;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        for (int l = 0, r = 0; r < nums.length; r++) {
            if (nums[r] == 0) continue;
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
        }
    }
}
