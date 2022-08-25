package AntraOA.eBay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class NoStrictlyIncreasingSequence {
    public static void main(String[] args) {
        System.out.println(check(new int[]{1,2,5,1,6,7}, 6));
        System.out.println(solution(new int[]{1,2,5,1,6,7}));
        System.out.println(checkIfIncreasing(new int[]{1,2,5,1,6,7}));
    }

    public static boolean solution(int[] arr){
        int pointer = -1;
        for(int i = 0; i< arr.length - 1; i++) {
            if(arr[i] >= arr[i + 1]) { // 被删掉的是i，max(i) = arr.length - 2
                if(pointer == -1) {
                    pointer = i;
                } else {
                    return false;
                }
            }
        }

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        for(int i = 0; i < list.size(); i++) {
        }

        // 此处以下说明只删掉了一次 i
        boolean res = false;
        if(pointer == -1 || pointer == 0 ) { // pointer = 0 删掉左边大的， pointer = arr.length - 2 时需满足第二个条件
            res = true;
        } else if(arr[pointer - 1] < arr[pointer + 1]) {
            return true;
        }
        return res;
    }

    public static boolean checkIfIncreasing(int[] seq){
        int pointer = -1;
        if(seq.length <= 1)
            return true;
        for(int i = 0; i < seq.length - 1; i++){
            if(seq[i] > seq[i + 1]){
                if(pointer == -1) {
                    pointer = i;
                }
                else
                    return false;
            }
        }
        boolean res = false;
        if(pointer == -1 || pointer == 0 || pointer == seq.length - 2)
            res = true;
        else if(seq[pointer - 1] < seq[pointer + 1])
            res = true;
        return res;

    }

    public static boolean check(int[] arr, int n)
    {

        // Stores the count of numbers that
        // are needed to be removed
        int count = 0;

        // Store the index of the element
        // that needs to be removed
        int index = -1;

        // Traverse the range [1, N - 1]
        for(int i = 1; i < n; i++)
        {

            // If arr[i-1] is greater than
            // or equal to arr[i]
            if (arr[i - 1] >= arr[i])
            {

                // Increment the count by 1
                count++;

                // Update index
                index = i;
            }
        }

        // If count is greater than one
        if (count > 1)
            return false;

        // If no element is removed
        if (count == 0)
            return true;

        // If only the last or the
        // first element is removed
        if (index == n - 1 || index == 1)
            return true;

        // If a[index] is removed
        if (arr[index - 1] < arr[index + 1])
            return true;

        // If a[index - 1] is removed
        if (index - 2 >= 0 && arr[index - 2] < arr[index])
            return true;

        // if there is no element to compare
        if(index < 0)
            return true;

        return false;
    }

}
