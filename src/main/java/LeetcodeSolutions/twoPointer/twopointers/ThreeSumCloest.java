package LeetcodeSolutions.twoPointer.twopointers;

import java.util.Arrays;

public class ThreeSumCloest {
    public static void main(String[] args) {
        /**
         * Input: nums = [-1,2,1,-4], target = 1
         * Output: 2
         * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
         */
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumCloest(nums, target));
    }

    private static int threeSumCloest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int res = nums[0] + nums[1] + nums[N - 1];
        for(int i = 0; i < N - 2; i++) {
            int left = i + 1, right = N - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;

                if(sum > target) right--;
                else left++;
            }
        }
        return res;
    }
 }
