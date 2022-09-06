package LeetcodeSolutions.twoPointer.twopointers;

import java.util.Arrays;

public class ThreeSumValidTriangleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,4};
        System.out.println(triangleNumber(nums)); // 3
    }
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int res = 0;
        for(int i = N - 1; i >= 2; i--) {
            int left = 0, right = i - 1;
            while(left < right) {
                if(nums[left] + nums[right] > nums[i]) {
                    res += right - left; // 反向遍历
                    right--;
                } else {
                    left++;
                }

            }
        }
        return res;
    }
}
