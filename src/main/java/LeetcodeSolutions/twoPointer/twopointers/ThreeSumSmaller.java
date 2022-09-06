package LeetcodeSolutions.twoPointer.twopointers;

import java.util.Arrays;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,1,3};
        int target = 2;
        System.out.println(threeSumSmaller(nums, target)); // res = 2 -> [-2,0,1]  [-2,0,3]
    }

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int res = 0;
        for(int i = 0; i< N - 2; i++) {
            int left = i + 1, right = N - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < target) {
                    res += right - left; // 在left 和 right之间的都可以
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
