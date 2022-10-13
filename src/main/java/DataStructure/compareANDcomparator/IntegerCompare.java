package DataStructure.compareANDcomparator;

import java.util.Arrays;
import java.util.Comparator;

public class IntegerCompare {

    public static void main(String[] args) {
        Integer[] nums = {Integer.MAX_VALUE, Integer.MIN_VALUE};

        Arrays.sort(nums, new MyComparator1()); // [2147483647, -2147483648]
        System.out.println(Arrays.toString(nums));    //错误：越界
        System.out.println(2147483647 - -2147483648); // = -1

        Arrays.sort(nums, new MyComparator2()); // [-2147483648, 2147483647] 正确
        System.out.println(Arrays.toString(nums));
    }
}

class MyComparator1 implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return a - b;
    }
}

class MyComparator2 implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return Integer.compare(a, b);
    }
}
