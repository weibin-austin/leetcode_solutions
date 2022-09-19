package LeetcodeSolutions.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    @Test
    public void basic_test() {
        System.out.println(combine(4, 2)); // [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]

    }

    public List<List<Integer>> combine(int n, int k) { // C(4,2)
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> level, int n, int k, int index) {
        if(level.size() == k) res.add(new ArrayList<>(level));
        else {
            for(int i = index; i <= n; i++) {
                level.add(i);
                dfs(res, level, n, k, i + 1);
                level.remove(level.size() - 1);
            }
        }
    }
}
