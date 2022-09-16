package LeetcodeSolutions.twoPointer.twopointers.SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MinimumSizeSubarraySum209 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[] {2,3,1,2,4,3};
        System.out.println(sliding(target, nums)); // 2
    }

    public static int sliding(int target, int[] nums) {
        int left = 0, res = Integer.MAX_VALUE, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= target) {  // 用while循环判断，因为不确定删掉之前的几个element
                res = Math.min(res, i - left + 1); // i- left + 1 举例：left = 0， i = 0, 但是subarray长度为1
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res; // eg: target: 11, nums = [1,1,1,1,1,1] never get subarray meet requirement
    }
//
//    public static int binaryOnAnsSet(int target, int[] nums) {
//    }
}
