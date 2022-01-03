package java;

class LongestPalindromicSubstringEn {
    // Solution 1: O(n^2)
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int pLen1 = expand(c, i, i);
            int pLen2 = expand(c, i, i + 1);
            int maxPLen = Math.max(pLen1, pLen2);
            if (maxPLen > (end - start)) {
                start = i - (maxPLen - 1) / 2;
                end = i + maxPLen / 2;
            }
        }
        return s.substring(start, end + 1);
        
    }
    
    private int expand(char[] c, int left, int right) {
        while (left >= 0 && right < c.length && c[left] == c[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
