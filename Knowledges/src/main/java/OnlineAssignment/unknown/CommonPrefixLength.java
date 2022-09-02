package OnlineAssignment.unknown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonPrefixLength {
    public static void main(String[] args) {
        List<String> inputs = Arrays.asList("abcabcd", "ababaa");
        List<Integer> res = commonPrefix(inputs);
        for(Integer n : res) {
            System.out.println(n);
        }

    }

    private static List<Integer> commonPrefix(List<String> inputs) {
        List<Integer> lList = new ArrayList<>();
        for(String s: inputs) {
            System.out.println(s + "");
            int n = s.length();
            int total = sumLength(s, n);
            lList.add(total);
        }
        return lList;
    }

    static Integer sumLength(String s, int n){
        int[] x = new int[n];
        getCArr(s, n, x);
        int total = n;
        for(int i = 1; i < n; i++) {
            total += x[i];
        }
        return total;
    }

    static void getCArr(String s, int n, int[] x) {
        int l = 0;
        int r = 0;
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(i > r) {
                l = r = i;
                while(r < n && s.charAt(r - l) == s.charAt(r)) {
                    r++;
                }
                x[i] = r - l;
                r--;
            } else {
                k = i - l;
                if(x[k] < r - i + 1) {
                    x[i] = x[k];
                } else {
                    l = i;
                    while(r < n && s.charAt(r - l) == s.charAt(r)) {
                        r++;
                    }
                    x[i] = r - l;
                    r--;
                }
            }
        }
    }
}
