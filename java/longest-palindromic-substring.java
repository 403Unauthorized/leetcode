// 5. 最长回文子串 - Medium
// https://leetcode-cn.com/problems/longest-palindromic-substring/
package java;

class LongestPalindromicSubstring {
    //  暴力解法
    // 遍历出所有的子串，找出最长的回文串
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLength = 1;
        String longestPalindrome = "" + s.charAt(0);
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder("" + s.charAt(i));
            for (int j = i + 1; j < len; j++) {
                sb.append(s.charAt(j));
                if (isPalindrome(sb.toString())) {
                    if (sb.length() > maxLength) {
                        longestPalindrome = sb.toString();
                        maxLength = sb.length();
                    }
                }
            }
            if (maxLength == len) break;
        }
        return longestPalindrome;
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
