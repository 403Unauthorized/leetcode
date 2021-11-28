// 438. 找到字符串中所有字母异位词 - Medium
// https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
package java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一开始我想的是用滑动窗口和位运算来做这道题，使用位运算计算出字符串p的值
 * 在使用滑动窗口的方式，找出所有和这个值相同的子串
 * 1 << (s.charAt(i) - 'a')
 * 消除某个字符的值：
 * 使用异或：mask ^= 1 << (s.charAt(left) - 'a');
 * 但是这种方法需要判断相同字符的情况：比如 s = 'baa', p = 'aa'
 * 这种方案相对麻烦
 * 
 * 所以我们使用了长度为26的数组，遇到一个字符，就将这个字符位置上的值+1
 * 每次加完之后判断是否等于 p 字符串的数组
 * 使用 Arrays.equals(int[] a, int[] b) 方法
 */
class FindAllAnagramsInAString {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            sCount[s.charAt(i - pLen) - 'a']--;
            sCount[s.charAt(i) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }
}
