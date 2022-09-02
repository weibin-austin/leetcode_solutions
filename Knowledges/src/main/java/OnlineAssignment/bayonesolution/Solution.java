package OnlineAssignment.bayonesolution;

import java.util.ArrayList;
import java.util.List;

/**
 *     Given an array of integers, return an array of integers which contains
 *     [1st integer, Sum of next 2 integers (2nd, 3rd), Sum of next 3 integers (4th, 5th, 6th)]
 *     Input size n [1,6,8,5,9,4,7,2] Output size m [1,14,18,9] Solution:
 */
public class Solution {
    public static void main(String[] args) {
        int [] testcase1 = new int []{1,6,8,5,9,4,7,2};
        System.out.println(solution1(testcase1));
    }

    private static List<Integer> solution(int[] arr) {
        if(arr == null || arr.length == 0) return new ArrayList<>();
        int count = 1;
        List<Integer> res = new ArrayList<>();
        for(int i = 0, sum = 0; i < arr.length;) {
            for(int j = 0; j < count && i < arr.length; j++, i++) {
                sum += arr[i];
            }
            count++;
            res.add(sum);
        }
        return res;
    }

    private static List<Integer> solution1(int[] arr) {
        if(arr == null || arr.length == 0) return new ArrayList<>();
        int count = 1;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < arr.length;) {
            int sum = 0;
            for(int j = 0; i < arr.length && j < count; j++) {
                sum += arr[i];
                i++;
            }
            count++;
            res.add(sum);
        }
        return res;
    }

    private static List<Integer> solution2(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, count = 1, len = arr.length;
        while(i < len && j < len) {
            int sum = 0;
            while( j < count && i < len) {
                sum += arr[i];
                i++;
                j++;
            }
            res.add(sum);
            count++;
            j = 0;
        }
        return res;
    }

    }
