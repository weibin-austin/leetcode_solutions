package LeetcodeSolutions.twoPointer.twopointers;

import java.util.*;

public class fourSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1000000000,1000000000,1000000000,1000000000};
//        System.out.println("sum :" + Arrays.stream(nums).sum());
        int target = -294967296;
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
        System.out.println(FourSum(nums, target));
    }

    public static List<List<Integer>> FourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int left, right, N = nums.length;
        for(int i = 0; i< N - 3; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < N - 2; j++) {
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                left = j + 1;
                right = N - 1;
                while(left < right) {
                    long sum = (long)nums[i] + (long)nums[j] +(long) nums[left] + (long)nums[right];
                    if(sum == (long)target) {
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left - 1]) left++;
                        while(left < right && nums[right] == nums[right + 1]) right++;
                    } else if(sum > target) right--;
                    else left++;
                }
            }
        }
        return res;
    }
}
