package LeetcodeSolutions.twoPointer.twopointers;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] dummy = nums.clone();
        Arrays.sort(dummy)        ;
        int left = 0, right = n - 1;
        while(left < right) {
            if(dummy[left] + dummy[right] < target) {
                left++;
            } else if(dummy[left] + dummy[right] > target) {
                right--;
            } else {
                break;
            }
        }

        int[] res = new int[2];
        for(int i = 0; i < n; i++) {
            if(dummy[left] == nums[i]) {
                res[0] = i;
            }
        }

        for(int i = n - 1; i >= 0; i--) {
            if(dummy[right] == nums[i]) {
                res[1] = i;
            }
        }

        return res;
    }
}