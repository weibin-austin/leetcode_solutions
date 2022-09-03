package LeetcodeSolutions.twoPointer.binarysearch;

import java.util.Arrays;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = new int[]{7,2,5,10,8};
        System.out.println(splitArray(nums, 2));
    }

    public static int splitArray(int[] nums, int m){
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        return binary(nums, m, sum, max);
    }

    public static int binary(int[] nums, int m, int high, int low) {
        int mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(valid(nums, m, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean valid(int[] nums, int m, int subArraySum) {
        int count = 1, curSum = 0;
        for(int num : nums) {
            curSum += num;
            if(curSum > subArraySum) {
                curSum = num;
                count++;
                if(count > m) return false;
            }
        }
        return true;
    }
}
