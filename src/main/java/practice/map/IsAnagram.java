package practice.map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

 链接：https://leetcode-cn.com/problems/valid-anagram
 *
 * 1. clarification
 * 2. possible solutions --> optimal (time & space)
 * 3. code
 * 4. test cases
 */
public class IsAnagram {

    /**
     * 使用HashMap, 一趟遍历, 时间复杂度O(n)，空间复杂度O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean map(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (alpha[i] != 0)
                return false;
        return true;
    }
}
