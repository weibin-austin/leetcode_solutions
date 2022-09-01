package LeetcodeSolutions.twoPointer;

public class ValidPalindrome {
    /**
     * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
     * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
     *
     * Example 1:
     *
     * Input: s = "A man, a plan, a canal: Panama"
     * Output: true
     * Explanation: "amanaplanacanalpanama" is a palindrome.
     * Example 2:
     *
     * Input: s = "race a car"
     * Output: false
     * Explanation: "raceacar" is not a palindrome.
     * Example 3:
     *
     * Input: s = " "
     * Output: true
     * Explanation: s is an empty string "" after removing non-alphanumeric characters.
     * Since an empty string reads the same forward and backward, it is a palindrome.
     *
     * Given a string s, return true if it is a palindrome, or false otherwise.
     * @param args
     */
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("('A man, a plan, a canal: Panama') is " + isPalindrome(s) +" Palindrome");
        String s1 = "race a car";
        System.out.println("('race a car') is " + isPalindrome(s1) +" Palindrome");

    }

    public static boolean isPalindrome(String s) {
        if(s.length() == 1) return true;
        int left = 0, right = s.length() - 1;
        while(left < right) {

            // while loop to remove invalid characters, require left < right
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // while loop to remove invalid characters, require left < right
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
