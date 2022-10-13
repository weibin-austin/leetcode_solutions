package OnlineAssignment.unknown;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] arg) {
        int[] nums = new int[]{2,4,3,7,1,2,3};

        int res = firstValue(nums);

        System.out.println(res);

    }

    public static int firstValue(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) return nums[i];
        }
        return -1;

    }
}
