import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Weibin Sun
 * @create 8/1/22 8:30 PM
 *
 * 二分查找法主要是解决"在一堆数中找到制定的数"这类问题。
 * 想要应用二分查找法，这一堆数，需要具有一下特征：
 * 1. 存储在数组中
 * 2. 数组有序排列 （如果是用链表存储，则无法在其上应用二分查找法）
 *
 * @Return: the position of the target in Array
 */
public class BinarySearchMethods {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,4,5,6,8,9,11,13,15};
        int[] nums = new int[]{1,2};
        int res = binarySearch1(nums, 2);
        System.out.println(res);
    }
    private static int binarySearch1( int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                start = mid + 1;
            }
            if(nums[mid] > target) {
                end = mid - 1;
            }
        }
        if(nums[start] == target) {
            return start;
        }
        return -1;
    }

    /*
     target = 13
     nums = [1,   2,   3,   4,   5,   7,   8,   10,   13,   16]
             L                                         T     R              L = 0, R = nums.length - 1 = 9



     nums = [1,   2,   3,   4,   5,   7,   8,   10,   13,   16]             int mid = L + (R - L)/2 = (0 + 9)/2 = 4
             L                   mid                         R              nums[mid] = 5 < 13 = target
                                                                            L = mid + 1 = 4 + 1 = 5


     nums = [1,   2,   3,   4,   5,   7,   8,   10,   13,   16]
                                      L   mid                R               R = 9
                                                                             mid = (4 + 9) / 2 = 6
                                                                             nums[mid] = nums[6] = 8 < 13 = target
                                                                             L = mid + 1 = 6 + 1 = 7


     nums = [1,   2,   3,   4,   5,   7,   8,   10,   13,   16]
                                                 L    mid    R               R = 9
                                                                             mid = (7 + 9) / 2 = 8
                                                                             nums[mid] = nums[8] = 13 = 13 = target -> return


     Special
     target =  1
     nums[1   ,   2]
          L       R         L = 0, R = 1 -> mid = (L + R) / 2 = 0
          mid               nums[mid] = nums[0] = 1 = target -> return 0



     target = 2
     nums[1   ,   2]        L = 0, R = 1 -> mid = (L + R) / 2 = 0
          L       R         nums[mid] = nums[0] = 1 < 2 = target
          mid               L = mid + 1 = 0 + 1 = 1 -> (L < R) violate -> L = R = 1 -> if (nums[L] == target or nums[R] == target)


     For binarySearch, if we use the way as
         // while(left < right)
         // if(nums[mid] < target) left = mid + 1
         // if(nums[mid] > target) right = mid - 1
         // if(nums[mid] == target) return mid
     When the while loop condition violated, we need to check one of below
        // if (nums[left] == target) return start;
        // if (nums[right] == target) return right;
     these two expression are same, we only need one because when the while loop condition violated, left = right.
     We only need to check one of them will be good.

     */
}
