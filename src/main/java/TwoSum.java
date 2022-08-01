import java.util.HashMap;
import java.util.Map;

/**
 * @author Weibin Sun
 * @create 7/31/22 9:55 PM
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 */
public class TwoSum {
    public static void main(String[] args) {
//        int[] nums = new int[] {2,7,11,15};
//        int target = 9;

        int[] nums = new int[] {3,2,4};
        int target = 6;

        int[] res;
        res = twoSum(nums, target);
        assert res != null;
        for(int n : res) {
            System.out.print(n + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return null;
    }
}
