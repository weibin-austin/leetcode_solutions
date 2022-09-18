package LeetcodeSolutions.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Permutations { // no duplicates in nums

    @Test
    public void swap_solution() {
        int[] nums = {1,2,3};
        System.out.println(permutations_swap(nums)); // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]

    }

    public List<List<Integer>> permutations_swap(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,nums,0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int index) {
        for(int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(res, nums, index + 1);
            swap(nums, index, i);
        }

        if(index == nums.length){
            List<Integer> ans = new ArrayList<>();
            for(int num: nums) ans.add(num);
            res.add(ans);
        }
    }

    public static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    @Test
    public void backtrack_solution() {
        int[] nums = {1,2,3};
        System.out.println(permutations_backtrack(nums)); // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
    }

    public List<List<Integer>> permutations_backtrack(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums) {
        if(tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(tmp.contains(nums[i])) continue;
                tmp.add(nums[i]);
                backtrack(res, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
