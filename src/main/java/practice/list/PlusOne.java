package practice.list;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.

  

 Example 1:

 Input: digits = [1,2,3]
 Output: [1,2,4]
 Explanation: The array represents the integer 123.
 Example 2:

 Input: digits = [4,3,2,1]
 Output: [4,3,2,2]
 Explanation: The array represents the integer 4321.
 Example 3:

 Input: digits = [0]
 Output: [1]
  

 Constraints:

 1 <= digits.length <= 100
 0 <= digits[i] <= 9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/plus-one
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] my(int[] digits) {
        int up = 0, i = digits.length - 1;
        while (i >= 0) {
            int add = i == digits.length - 1 ? 1 : 0;
            int sum = digits[i] + add + up;
            digits[i] = sum % 10;
            up = sum >= 10 ? 1 : 0;
            i--;
        }
        if (up > 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }
}
