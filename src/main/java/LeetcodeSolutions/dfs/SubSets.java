package LeetcodeSolutions.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    @Test
    public void basic_test() {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), nums, 0); // 需要找不同个数的，就需要index来limit每次遍历的个数
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> tmp, int[] nums, int start) {
        res.add(new ArrayList<>(tmp)); // reference pass by value(address value)
        for(int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(res, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
