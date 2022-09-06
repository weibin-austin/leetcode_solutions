package DataStructure.arrayANDstring;

public class StringLearning {
    /**
     *  String is a non-primitive data type.
     *
     *  primitive data type: boolean, int, char, double, long, byte, short, float
     *  non-primitive data type: Strings, Arrays, Classes, Interfaces
     * @param args
     */
    public static void main(String[] args) {
        String str = new String("String1");
        System.out.println(str);
        str = new String(new char[]{'S','t','r','i','n','g','2'});
        System.out.println(str);

        String substring1 = str.substring(1); // [1, ∞)
        System.out.println(substring1);

        String substring2 = str.substring(1, 4); // [1, 4); -> "tri"
        System.out.println(substring2);

        String substring3 = str.substring(1, 2); // [1, 2); -> "t"
        System.out.println(substring2);

        char c = str.charAt(1); // 't'
        System.out.println(c);


        String s1 = "abc"; // "abc"          "abc"           "abc"         "aaa"
        String s2 = "cba"; // "cba" -> -2,   "dba" -> -3,    "aba" -> 2,   "aza" -> -3
                           // 'a'-'c'= -2    'a'-'d'= -3     'c'-'a'= 2    'a'-'z' =-25
        int i = s1.compareTo(s2); //
        System.out.println(i);

//        char ch = '1';
        String sss ="123";
//        System.out.println(Integer.valueOf(sss, 2));
        System.out.println(Integer.valueOf(sss));

    }
}
