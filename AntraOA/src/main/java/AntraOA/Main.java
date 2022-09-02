package AntraOA;

/**
 * @author Weibin Sun
 * @create 8/1/22 12:28 AM
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "ab4562c";
        System.out.println();
        String s2 = "ab4562c";
        System.out.println(s2.hashCode());

        String s3 = new String("ab4562c");
        System.out.println(s3.hashCode());

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s2.equals(s3));

    }


}
