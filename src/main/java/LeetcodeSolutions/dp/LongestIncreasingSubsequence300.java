package LeetcodeSolutions.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence300 { // two pointer的DP
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18,10,9,2,5,3,7,101,18,7,101,18,7,101,18,7,101,3,7,101,18,3,7,101,18,3,7,101,18,3,7,101,18,3,7,101,18,18,7,101,18,7,101,18,7,101,18,7,101,18,7,101,18,7,101,18,7,101,18,7,101,18,7,101,18,7,101,18,7,101,18,7,101,18,7,101,18,7,101,18 };
        final long startTime = System.nanoTime();
//        System.out.println(lengthOfLIS_DP(nums)); // 248750
//        System.out.println(lengthOfLIS_List(nums)); //181375
        System.out.println(lengthOfLIS_List_BinarySearch(nums)); // 212291
        final long endTime = System.nanoTime();
        System.out.println("Total execution time: " + (endTime - startTime));

    }
/*                 0    1    2    3    4    5    6    7
     nums[i]      10    9    2    5    3    7   101  18

     nums[j]      10    9    2    5    3    7   101  18

     dp[i]        1     1    1    2    2    3    4    4
 */
    private static int lengthOfLIS_DP(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++) { // i从第二个值开始向后扫描
            for(int j = 0; j < i; j++) {       // 每次从第一个值扫描到第i个值 O(n^2)的时间复杂度
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1); // 每次j循环都需要update dp[i] 的值。 dp[i]本身或dp[j] + 1
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }

    private static int lengthOfLIS_List(int[] nums) {
        if(nums.length == 0 ) return 0;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = 0;
                while(num > sub.get(j)) j++;  // 有序排列，找target 二分法O(logn) 更好, 二分法找下标
                sub.set(j, num);
            }
        }
         return sub.size();
    }

    private static int lengthOfLIS_List_BinarySearch(int[] nums) {
        if(nums.length == 0) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if(num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int j = binarySearch(list, num);
                list.set(j, num);
            }
        }
        return list.size();
    }

    private static int binarySearch(List<Integer> list, int target) { // 二分法板子3 -> 最后 (right, left), return left。返回最右边的
        int left = 0, right = list.size() - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid) > target) {
                right = mid - 1;
            } else if(list.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
