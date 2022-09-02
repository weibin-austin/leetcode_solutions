package LeetcodeSolutions.twoPointer.binarysearch;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class FirstLastPositionTarget {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 8))); //[3,4]
    }

    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    public static int findLast(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) {              // 找Last Position需要二分发的左界限右移
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if(nums[mid] == target) {              // 找到目标位置后，记录当前nums[mid]的值到index
                index = mid;
            }
        }
        return index;
    }

    public static int findFirst(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {               // 找First Position需要二分法的右界限左移
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if(nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
}
