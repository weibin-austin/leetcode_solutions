package OnlineAssignment.unknown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box {
    public static void main(String[] args) {
        List<List<Integer>> queries = Arrays.asList(Arrays.asList(2,1), Arrays.asList(2,3));
        List<Long> longs = numberOfWays(queries);
        for(Long l : longs) {
            System.out.println(l);
        }
    }

    public static List<Long> numberOfWays(List<List<Integer>> queries) {
        List<Long> res = new ArrayList<>();
        for(List<Integer> query: queries)  {
            Long total = 0l;
            Integer row = query.get(0);
            Integer column = query.get(1);
            total = row > column ? getTotal(row, column) : getTotal(column, row);
            res.add(total);
        }
        return res;
    }

    private static Long getTotal(Integer big, Integer small) {
        Long res = 0l;
        while(small > 0) {
            res += big * small;
            big--;
            small--;
        }
        return res;
    }
}

