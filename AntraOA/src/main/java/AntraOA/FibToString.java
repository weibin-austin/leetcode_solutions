package AntraOA;

public class FibToString {
    public static void main(String[] args) {
        String[] strings = new String[10];
        for(int i = 0; i < 10; i++) {
            strings[i] = String.valueOf(fib(i));
        }
        for(String s: strings) {
            System.out.print(s + " ");
        }
    }

    private static long fib(int i) {
        if(i < 2) return i;
        long a = 0L, b = 1L;
        while(i-- > 1) {
            long sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
