package AntraOA.eBay;

public class SubString {
    public static void main(String[] args) {


        final long startTime = System.currentTimeMillis();

        String str = "afg";
//        int i = splitToSubString(str, 5);
        int i = subArray(str, 5);
        System.out.println(i);

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));


    }

    /*
                 m    q    f    g    k    d    e
                 13   17   6    7    11   4    5
                 12   16   5    6    10   3    4
     */

    public static int subArray(String str, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int n = str.length();

        if( k == 0) {
            return n;
        }
        int count = 1;
        for(int i = 0; i < n; i++) {
            max = Math.max(str.charAt(i) - 'a', max);
            min = Math.min(str.charAt(i) - 'a', min);

            if(max - min > k) {
                max = str.charAt(i) - 'a';
                min = str.charAt(i) - 'a';
                count++;
            }
        }
        return count;
    }


    public static int splitToSubString(String str, int k) {
        //O(n)
        int N = str.length();
        int count = 1;
        if(N <= 1)
            return N;
        for(int i = 1; i < N; i++){
            if(Math.abs(str.charAt(i) - str.charAt(i - 1)) <= k)
                continue;
            else{
                count++;
            }
        }
        return count;
    }


}
