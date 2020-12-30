package practice.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]
 Note:

 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 You can return the answer in any order.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequent {

    /**
     * 空间复杂度O(n), 其中n <= nums.length
     * 时间复杂度O(n log k), 其中只需要维护节点为k的堆即可, 符合topK的排序问题
     * @param nums
     * @param k
     * @return
     */
    public int[] heap(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums)
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) { return m[1] - n[1]; }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums)
            counter.put(n, counter.getOrDefault(n, 0) + 1);

        int c = 0;
        int[][] arr = new int[counter.size()][2];
        for (int key : counter.keySet())
            arr[c++] = new int[]{key, counter.get(key)};
        int[] res = new int[k];
        if (counter.size() == 1) {
            res[0] = nums[0];
            return res;
        }
        qsort(arr, 0, arr.length - 1, k, res);
        print(arr);
        for (int n = 0; n < k; n++)
            res[n] = arr[n][0];
        return res;
    }

    public void print(int[][] arr) {
        System.out.printf("[\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(" [");
            for (int j = 0; j < arr[i].length; j++)
                System.out.printf("%d, ", arr[i][j]);
            System.out.printf("]\n");
        }
        System.out.printf("]\n");
    }

    public void qsort(int[][] arr, int start, int end, int k, int[] res) {
        System.out.printf("-> start=%d, end=%d, k=%d\n", start, end, k);
        print(arr);
        if (start >= end) return;
        int pivot = arr[start][1];
        int i = start, j = end;
        while (i < j) {
            while (i < j && pivot >= arr[j][1]) j--;
            if (i < j) swap(arr, i++, j);
            while (i < j && pivot < arr[i][1]) i++;
            if (i < j) swap(arr, i, j--);
        }
        if (k <= i - start) {
            qsort(arr, start, i - 1, k, res);
        } else if (k > i - start + 1) {
            qsort(arr, i + 1, end, k - (i - start + 1), res);
        }
    }

    public void swap(int[][] arr, int i, int j) {
        for (int k = 0; k < arr[i].length; k++) {
            int temp = arr[i][k];
            arr[i][k] = arr[j][k];
            arr[j][k] = temp;
        }
    }
}
