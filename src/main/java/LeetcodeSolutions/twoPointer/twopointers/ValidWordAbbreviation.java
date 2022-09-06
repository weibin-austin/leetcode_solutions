package LeetcodeSolutions.twoPointer.twopointers;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i12iz4n";
        System.out.println(validWordAbbreviation(word, abbr));
    }
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while(i < abbr.length() && j < word.length()) {  // 条件控制链: 只用if语句来锁定满足某一条件时的操作
            if(abbr.charAt(i) == word.charAt(j)) {  // 最简单的条件1
                i++;
                j++;
                continue;
            }

            if(!Character.isDigit(abbr.charAt(i))) return false; // 不满足条件1时，满足条件2时

            if(abbr.charAt(i) == '0') return false; // 不满足条件1，满足条件3时

            int n = 0;
            while(i < abbr.length() && Character.isDigit(abbr.charAt(i))) { // 满足条件4
                n = n * 10 + (abbr.charAt(i) - '0');
                i++;
            }
            j = j + n;

        }
        return i == abbr.length() && j == word.length(); //结束条件
    }
}
