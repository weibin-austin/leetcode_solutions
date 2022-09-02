package OnlineAssignment.unknown;

import java.util.Arrays;
import java.util.List;

public class MinimumStartValue {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(6,5,3,-7,-3,-8,-9,2,9);
        int res = minX(arr);
        System.out.println(res);
    }
    public static int minX(List<Integer> arr) {
        int min = 0;
        int sum = 0;
        for(Integer a : arr) {
            sum += a;
            min = Math.min(min, sum);
        }
        return 1 - min;
    }
}
