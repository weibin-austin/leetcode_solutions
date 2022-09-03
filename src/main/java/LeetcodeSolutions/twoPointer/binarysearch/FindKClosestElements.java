package LeetcodeSolutions.twoPointer.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(customerComparator(arr, 4, 3));
        System.out.println(binarySearchAndSlidingWindow(arr, 4, 9));

    }

    /**
     *  Create a customer Comparator, we considered every single number from arr as a potential candidate for the final output.
     * @param arr input array
     * @param k the number of elements which is closer to target x
     * @param x target x
     * @return Lis<Integer>
     *     TC: O(nlogn + klogk), n is the arr[] size, k is the target size;
     *         O(nlogn) is because the customized comparator
     *         O(klogk) is because the sort of result k elements
     *
     *     SC:
     */
    public static List<Integer> customerComparator(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        for(int a: arr) { // O(n)
            list.add(a);
        }
        Collections.sort(list, Comparator.comparingInt(a -> Math.abs(a - x))); //O(nlogn)
        list = list.stream().limit(k).collect(Collectors.toList()); // find the first k
        Collections.sort(list); //O(klogk)
        return list;
    }

    /**
     * Every time you see a problem that involves a sorted array, you should consider binary search.
     * @param arr
     * @param k
     * @param x
     * @return
     *
     * TC: O(logn + k), n is the arr[] size, k is the sliding windows size
     * SC: O(1)
     */
    public static List<Integer> binarySearchAndSlidingWindow(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr.length == k) {
            for(int a: arr) res.add(a);
            return res;
        }

        int left = 0, right = arr.length - 1;
        while(left <= right) {  // binary search O(logn) n is arr[] size
            int mid = left + (right - left) / 2;
            if(arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left--;
        right = left + 1;
        while(right - left < k + 1) { // O(logn + k) n is the arr[] size, k is the sliding window size
            if(left == -1) {
                right++;
                continue;
            }
            if(right == arr.length) {
                left--;
                continue;
            }
            if(Math.abs(arr[left] - x) > Math.abs(x - arr[right])) {
                right++;
            } else {
                left--;
            }
        }
        for(int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}


