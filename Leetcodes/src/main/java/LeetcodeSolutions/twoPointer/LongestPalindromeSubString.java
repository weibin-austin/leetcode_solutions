package LeetcodeSolutions.twoPointer;

/**
 *    Given a string s, return the longest palindromic substring in s.
 *
 *    Example 1:
 *
 *    Input: s = "babad"
 *    Output: "bab"
 *    Explanation: "aba" is also a valid answer.
 *    Example 2:
 *
 *    Input: s = "cbbd"
 *    Output: "bb"
 *
 *
 *    Constraints:
 *
 *    1 <= s.length <= 1000
 *    s consist of only digits and English letters.
 *
 *    Idea: Iterating, traversing or Looping each character in String
 *          ['b','a','b','a','d']
 *            ^
 *          反向双指针，用中间i位置 或 i & i+1 位置开始，向左右两侧移动指针，判断左右两个指针对应的字符是否相等
 *          循环结束条件触发，说明此时移动过的左右指针不满足回文数条件，需要返回上一次循环体的回文子串。
 *          return s.substring(left + 1, right) = [left + 1, right)
 *
 *          需要获取 oddPalindrome 和 evenPalindrome 来比较大小
 *          String oddPalindrome = getPalindrome(s, i, i); // i位置是开始位置，左右指针向两侧移动
 *          String evenPalindrome = getPalindrome(s, i, i + 1); // i 和 i+1 是开始位置
 *
 */
public class LongestPalindromeSubString {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if(s.length() == 0 || s == null) return "";
        if(s.length() == 1) return s;
        String res  = "";
        for(int i = 0; i < s.length(); i++) {
            String oddPalindrome = getPalindrome(s, i, i);
            if(oddPalindrome.length() > res.length()) res = oddPalindrome;

            String evenPalindrome = getPalindrome(s, i, i + 1);
            if(evenPalindrome.length() > res.length()) res = evenPalindrome;
        }
        return res;
    }

    private static String getPalindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
