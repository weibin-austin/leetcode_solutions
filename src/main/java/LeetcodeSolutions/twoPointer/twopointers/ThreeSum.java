package LeetcodeSolutions.twoPointer.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        int[] nums1 = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum(nums1));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // sort之后可以利用数组的特性使用双指针
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue; // 判断重复1，这里用if判断是因为已经在for循环内，会判断每一个扫描到的i

            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            while(left < right) {
                if(nums[left] + nums[right] == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) { // 判断重复left指针是否重复
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]) { // 判断重复right指针是否重复
                        right--;
                    }
                } else if(nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
