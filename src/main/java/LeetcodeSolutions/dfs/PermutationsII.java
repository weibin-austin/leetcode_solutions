package LeetcodeSolutions.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII { // has duplicates in nums
    @Test
    public void basic_test() {
        int[] nums = {1,1,2};
        System.out.println(solution(nums));
    }

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> tmp, int[] nums, boolean[] visited) {
        if(tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(visited[i] || i != 0 && nums[i] == nums[i - 1] && visited[i-1]) continue;
                tmp.add(nums[i]);
                visited[i] = true;
                backtrack(res, tmp, nums,visited);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }

}
