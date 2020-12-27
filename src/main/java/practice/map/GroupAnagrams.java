package practice.map;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 Example 1:

 Input: strs = ["eat","tea","tan","ate","nat","bat"]
 Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 Example 2:

 Input: strs = [""]
 Output: [[""]]
 Example 3:

 Input: strs = ["a"]
 Output: [["a"]]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/group-anagrams
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams {

    /**
     * 需要对每个字符串排序, 假设字符串平均长度为K, 时间复杂度在O(N * K * logK), 空间复杂度在O(N)
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            List<String> rows = map.getOrDefault(key, new ArrayList<>());
            rows.add(str);
            map.put(key, rows);
        }
        return new ArrayList<>(map.values());
    }
}
