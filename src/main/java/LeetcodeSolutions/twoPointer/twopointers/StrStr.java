package LeetcodeSolutions.twoPointer.twopointers;

public class StrStr {
    /**
     *     Implement strStr().
     *
     *     Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     *     Clarification:
     *
     *     What should we return when needle is an empty string? This is a great question to ask during an interview.
     *
     *     For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
     *
     *
     *
     *     Example 1:
     *
     *     Input: haystack = "hello", needle = "ll"
     *     Output: 2
     *     Example 2:
     *
     *     Input: haystack = "aaaaa", needle = "bba"
     *     Output: -1
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if(needle == "" || needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;
        int h = 0, n = 0;
        while(h < haystack.length() && n < needle.length()) {
            if(haystack.charAt(h) != needle.charAt(n)) {
                h = h - n;
                n = 0;
            } else {
                n++;
            }
            h++;
        }
        return n != needle.length() ? -1 : h - n;
    }
}

//" h l e l l o "    " l l "
//. ^                  ^
//.   ^                ^
//.     ^                ^
//.       ^            ^
//.         ^            ^
//            ^             ^
//  0 1 2 3 4 5         0 1  2
