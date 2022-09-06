package LeetcodeSolutions.twoPointer.twopointers;

import java.util.Arrays;

public class MoveZeros {
    //TODO: unresolved
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 0, 12, 15};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeros(int[] nums) {
        int left = 0, N = nums.length;
        for(int right = 0; right < N; right++) {
            if(nums[right] != 0) {
                nums[left++] = nums[right];
            }
            while(left < N) nums[left++] = 0;
        }
    }
}
