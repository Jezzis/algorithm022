package practice.pointer;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

  

 Example 1:


 Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 Example 2:

 Input: height = [4,2,0,3,2,5]
 Output: 9
  

 Constraints:

 n == height.length
 0 <= n <= 3 * 104
 0 <= height[i] <= 105

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/trapping-rain-water
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trap {

    public int trap(int[] height) {
        int res = 0, ml = 0, mr = 0, l = 0, r = height.length - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] > ml)
                    ml = height[l];
                else
                    res += ml - height[l];
                l++;
            } else {
                if (height[r] > mr)
                    mr = height[r];
                else
                    res += mr - height[r];
                r--;
            }
        }
        return res;
    }
}
