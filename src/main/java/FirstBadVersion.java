/**
 * @author Weibin Sun
 * @create 8/3/22 4:40 PM
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * Binary Search to find the first bad version
 *
 */
public class FirstBadVersion {
    public static boolean[] arr =
            {false, false, false, false, false, false, false, false, true, true, true, true, true, true, true,};

    public static boolean[] arr1 =
            {false, false, false, true, true, true, true, true, true, true, true, true, true, true, true,};

    public static void main(String[] args) {
        int n = arr1.length;
        int index = firstBadVersion(n);
        System.out.println(index);
    }

    public static boolean isBadVersion(int version) {
//        return arr[version - 1];
        return arr1[version - 1];
    }

    /**
     *
     * @param n total length of the array
     * @return index of the first bad version
     *
     * Binary Search
     *
     * Situation 1 : False longer than True
     *
     * [1   2   3   4   5   6   7   8   9   10   11   12   13]
     * [F   F   F   F   F   F   F   F   T    T    T    T    T]
     *  L                       M                           R
     *                              L        M              R
     *                              LM  R
     *                                 LMR                          L = R, M=true, R = M-1 -> return Left position
     *
     *  Situation 2 : False shorter than True
     *
     * [1   2   3   4   5   6   7   8   9   10   11   12   13]
     * [F   F   F   T   T   T   T   T   T    T    T    T    T]
     *  L                       M                           R
     *  L       M           R
     *              L   M   R
     *             LMR                                            L = R, M = true, R = M-1 -> then return Left position
     *
     *
     *
     *  Note:
     *  // while( left <= right )
     *  //   if(false) left = mid + 1;
     *  //   if(true) right = mid - 1;
     *  // return left;
     *
     *  Edge situation: L = R,
     *      if L = R -> ture, then move R, and L is the first True
     *      if L = R -> false, then move L = mid + 1, then L is the first True
     */
    public static int firstBadVersion(int n) {
        int left = 0, right = n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
