package LeetcodeSolutions.twoPointer.palindrome;

public class ValidPalindromeDeleteOne {
    /**
     * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "aba"; // true
        System.out.println(validPalindrome(s1));

        String s2 = "abca"; // true
        System.out.println(validPalindrome(s2));

        String s3 = "abc"; // false
        System.out.println(validPalindrome(s3));

    }

    public static boolean validPalindrome(String s) {
        if(s.length() < 3) return true;
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return check(s, left + 1, right) || check(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean check(String s, int left, int right) { // 把判断回文数的方法摘出来
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
