package LeetcodeSolutions.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SubSetsII {
    @Test
    public void basic_test() {
       int[] nums = {1,2,2};
        System.out.println(solution(nums));
    }

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, int index) {
        res.add(new ArrayList<>(tmp));
        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i - 1]) continue; // 做一个相同的check
            tmp.add(nums[i]);
            backtrack(res, tmp, nums, i + 1 );
            tmp.remove(tmp.size() - 1);
        }
    }
}
