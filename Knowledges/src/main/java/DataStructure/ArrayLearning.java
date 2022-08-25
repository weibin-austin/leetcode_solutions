package DataStructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class ArrayLearning {
    public static void main(String[] args) {

//        初始化数组
        int[] nums = new int[10];
        nums[0] = 1;
        //System.out.println(Arrays.toString(nums));

        int[] arr = new int[]{36, 11, 23, 5, 7, 15, 27};
        //System.out.println(Arrays.toString(arr));

        String[] strings = new String[]{"water", "color", "student", "teacher", "fire", "wood"};
        //System.out.println(Arrays.toString(strings));

//        java.util.Arrays; 包内的方法

//        用于：primitive data type Array & Object[], 没有比较器. 基本数据类型是用 x.compareTo(y) 来排序
        Arrays.sort(arr);
        //System.out.println("Ascending order: " + Arrays.toString(arr));


//        用于: wrapper type Array & reference type Array -> Arrays.sort(T[], Comparator<? super T> c)
//        !!! Only Integer[] Character[] ... !!!!
        Integer[] arr1 = new Integer[]{36, 11, 23, 5, 7, 15, 27};
        Arrays.sort(arr1, Collections.reverseOrder());
        //System.out.println("Descending order: " + Arrays.toString(arr1));



/* 二维数组 */

        int[][] array = new int[10][3];
        for(int i = 0; i < 10; i++) {
            array[i][0] = i;
            array[i][1] = i * 10;
            array[i][2] = i * 100;
            //System.out.println(Arrays.toString(array[i]));
        }

        //System.out.println(Arrays.toString(array));

        int[][] intervals = new int[][]{
                {1, 30},
                {11, 19},
                {15, 29}
        };

//        !!! int[0] and int[1] both reference data type array!!! 可以用 Arrays.sort(T[], Comparator<? super T> c)
        Arrays.sort(intervals, (a, b) ->  a[0] - b[0]);
        Arrays.sort(intervals, (a, b) ->  Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(intervals, (a, b) -> Objects.equals(a[0], b[0]) ? a[1] - b[1] : a[0] - b[0]);

        /*     比较器的写法：
                1. 直接比较              (a, b) ->  a[0] - b[0]
                2. Integer的静态方法     (a, b) ->  Integer.compare(a[0], b[0])
       IDE推荐： 3. Comparator的静态方法  Comparator.comparingInt(o -> o[1])
                4. 自定义比较器方法：     (a, b) -> Objects.equals(a[0], b[0]) ? a[1] - b[1] : a[0] - b[0]


       */

        for(int[] interval: intervals) {
            System.out.println(Arrays.toString(interval));
        }


    }
}
